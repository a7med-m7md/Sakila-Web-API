package com.iti.controllers.soap;

import com.iti.mappers.PaymentResponseMapper;
import com.iti.models.request.PaymentRequestDto;
import com.iti.models.response.PaymentResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.PaymentRepository;
import com.iti.services.PaymentService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.mapstruct.factory.Mappers;

import java.util.List;


@WebService
public class PaymentWebService {

    private PaymentService paymentService;

    public PaymentWebService() {
        paymentService = new PaymentService(new PaymentRepository(JPAFactoryManager.createEntityManager()),
                Mappers.getMapper(PaymentResponseMapper.class));
    }

    @WebMethod
    public List<PaymentResponseDto> getAllPayments(int page, int size) {
        if(page == 0 || size == 0){
            page = 1;
            size = 10;
        }
        return paymentService.findAll(page, size);
    }

    @WebMethod
    public void createPayment(@WebParam(name = "paymentRequestDto") PaymentRequestDto paymentRequestDto) {
        paymentService.save(paymentRequestDto);
    }

    @WebMethod
    public PaymentResponseDto getPayment(@WebParam(name = "paymentId") int paymentId) {
        return paymentService.findById(paymentId);
    }

    @WebMethod
    public void updatePayment(@WebParam(name = "paymentId") int paymentId, @WebParam(name = "paymentRequestDto") PaymentRequestDto paymentRequestDto) {
        paymentService.update(paymentRequestDto, paymentId);
    }

    @WebMethod
    public void deletePayment(@WebParam(name = "paymentId") int paymentId) {
        paymentService.deleteById(paymentId);
    }
}
