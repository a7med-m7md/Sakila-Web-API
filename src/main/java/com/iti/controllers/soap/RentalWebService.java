package com.iti.controllers.soap;

import com.iti.controllers.soap.exceptions.SoapException;
import com.iti.mappers.RentalMapper;
import com.iti.models.request.RentalRequestDto;
import com.iti.models.response.RentalResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.RentalRepository;
import com.iti.services.RentalService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.mapstruct.factory.Mappers;

import java.util.List;

@WebService
public class RentalWebService {
    private RentalService rentalService;

    public RentalWebService() {
        rentalService = new RentalService(
                new RentalRepository(JPAFactoryManager.createEntityManager()),
                Mappers.getMapper(RentalMapper.class));
    }

    @WebMethod
    @WebResult(name = "rental")
    public List<RentalResponseDto> getAllRentals(
            @WebParam(name = "page") int page,
            @WebParam(name = "size") int size) {
        try {
            return rentalService.findAll(page, size);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void createRental(
            @WebParam(name = "rental") RentalRequestDto rentalRequestDto) {
        try {
            rentalService.save(rentalRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    @WebResult(name = "rental")
    public RentalResponseDto getRental(
            @WebParam(name = "rentalId") int rentalId) {
        try {
            return rentalService.findById(rentalId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void updateRental(
            @WebParam(name = "rentalId") int rentalId,
            @WebParam(name = "rental") RentalRequestDto rentalRequestDto) {
        try {
            rentalService.update(rentalRequestDto, rentalId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void deleteRental(
            @WebParam(name = "rentalId") int rentalId) {
        try {
            rentalService.deleteById(rentalId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }
}
