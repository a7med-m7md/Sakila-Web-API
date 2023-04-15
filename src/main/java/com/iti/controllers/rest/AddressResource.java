package com.iti.controllers.rest;

import com.iti.models.request.AddressRequestDto;
import com.iti.models.response.AddressResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.services.AddressService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("location/addresses")
public class AddressResource {
    AddressService addressService;
    public AddressResource(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        addressService = new AddressService(entityManager);
    }


    @GET
    public Response getAllAddresses(@DefaultValue("1") @QueryParam("page") int page,
                                    @DefaultValue("10") @QueryParam("size") int size){
        List<AddressResponseDto> addressResponseDtoList = addressService.getAllAddresses(page, size);
        return Response.ok().entity(addressResponseDtoList).build();
    }


    @POST
    public Response createAddress(AddressRequestDto addressRequestDto){
        addressService.createAddress(addressRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("{addressId}")
    @GET
    public Response getAddress(@PathParam("addressId") int addressId){
        AddressResponseDto addressResponseDto = addressService.getOneAddress(addressId);
        return Response.ok().entity(addressResponseDto).build();
    }

    @Path("{addressId}")
    @PUT
    public Response updateAddress(@PathParam("addressId") int addressId, AddressRequestDto addressRequestDto){
        addressService.updateAddress(addressId, addressRequestDto);
        return Response.noContent().build();
    }

    @Path("{addressId}")
    @DELETE
    public Response deleteAddress(@PathParam("addressId") int addressId){
        addressService.deleteAddress(addressId);
        return Response.noContent().build();
    }

}
