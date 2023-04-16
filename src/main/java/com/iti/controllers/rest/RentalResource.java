package com.iti.controllers.rest;

import com.iti.mappers.PaymentResponseMapper;
import com.iti.mappers.RentalMapper;
import com.iti.models.request.PaymentRequestDto;
import com.iti.models.request.RentalRequestDto;
import com.iti.models.response.PaymentResponseDto;
import com.iti.models.response.RentalResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.PaymentRepository;
import com.iti.persistence.repository.RentalRepository;
import com.iti.services.PaymentService;
import com.iti.services.RentalService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Path("rentals")
public class RentalResource {
    RentalService rentalService;
    public RentalResource(){
        rentalService = new RentalService(new RentalRepository(JPAFactoryManager.createEntityManager()),
                Mappers.getMapper(RentalMapper.class));
    }
    @GET
    public Response getAllPayments(@DefaultValue("1") @QueryParam("page") int page,
                                   @DefaultValue("10") @QueryParam("size") int size){
        List<RentalResponseDto> rentalResponseDtos = rentalService.findAll(page, size);
        return Response.ok().entity(rentalResponseDtos).build();
    }

    @POST
    public Response createPayment(RentalRequestDto rentalRequestDto){
        rentalService.save(rentalRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("{rentalId}")
    public Response getPayment(@PathParam("rentalId") int rentalId){
        RentalResponseDto rentalResponseDto = rentalService.findById(rentalId);
        return Response.ok().entity(rentalResponseDto).build();
    }

    @PUT
    @Path("{rentalId}")
    public Response updatePayment(@PathParam("rentalId") int rentalId, RentalRequestDto rentalRequestDto){
        rentalService.update(rentalRequestDto, rentalId);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{rentalId}")
    public Response deletePayment(@PathParam("rentalId") int rentalId){
        rentalService.deleteById(rentalId);
        return Response.noContent().build();
    }
}
