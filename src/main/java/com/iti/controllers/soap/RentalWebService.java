package com.iti.controllers.soap;

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
        return rentalService.findAll(page, size);
    }

    @WebMethod
    public void createRental(
            @WebParam(name = "rental") RentalRequestDto rentalRequestDto) {
        rentalService.save(rentalRequestDto);
    }

    @WebMethod
    @WebResult(name = "rental")
    public RentalResponseDto getRental(
            @WebParam(name = "rentalId") int rentalId) {
        return rentalService.findById(rentalId);
    }

    @WebMethod
    public void updateRental(
            @WebParam(name = "rentalId") int rentalId,
            @WebParam(name = "rental") RentalRequestDto rentalRequestDto) {
        rentalService.update(rentalRequestDto, rentalId);
    }

    @WebMethod
    public void deleteRental(
            @WebParam(name = "rentalId") int rentalId) {
        rentalService.deleteById(rentalId);
    }
}
