package com.iti.controllers.rest;

import com.iti.mappers.PaymentResponseMapper;
import com.iti.models.request.PaymentRequestDto;
import com.iti.models.response.PaymentResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.PaymentRepository;
import com.iti.services.PaymentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Path("payments")
public class PaymentResource {
    PaymentService paymentService;
    public PaymentResource(){
        paymentService = new PaymentService(new PaymentRepository(JPAFactoryManager.createEntityManager()),
                Mappers.getMapper(PaymentResponseMapper.class));
    }
    @GET
    public Response getAllPayments(@DefaultValue("1") @QueryParam("page") int page,
                                   @DefaultValue("10") @QueryParam("size") int size){
        List<PaymentResponseDto> paymentResponseDtoList = paymentService.findAll(page, size);
        return Response.ok().entity(paymentResponseDtoList).build();
    }

    @POST
    public Response createPayment(PaymentRequestDto paymentRequestDto){
        paymentService.save(paymentRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{paymentId}")
    public Response getPayment(@PathParam("paymentId") int paymentId){
        PaymentResponseDto paymentResponseDto = paymentService.findById(paymentId);
        return Response.ok().entity(paymentResponseDto).build();
    }

    @PUT
    @Path("{paymentId}")
    public Response updatePayment(@PathParam("paymentId") int paymentId, PaymentRequestDto paymentRequestDto){
        paymentService.update(paymentRequestDto, paymentId);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{paymentId}")
    public Response deletePayment(@PathParam("paymentId") int paymentId){
        paymentService.deleteById(paymentId);
        return Response.noContent().build();
    }
}
