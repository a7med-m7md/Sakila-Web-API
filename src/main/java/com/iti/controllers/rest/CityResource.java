package com.iti.controllers.rest;

import com.iti.models.request.AddressRequestDto;
import com.iti.models.request.CityRequestDto;
import com.iti.models.response.AddressResponseDto;
import com.iti.models.response.CityResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.services.AddressService;
import com.iti.services.CityService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("location/cities")
public class CityResource {

    CityService cityService;
    public CityResource(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        cityService = new CityService(entityManager);
    }


    @GET
    public Response getAllCities(@DefaultValue("1") @QueryParam("page") int page,
                                    @DefaultValue("10") @QueryParam("size") int size){
        List<CityResponseDto> cityResponseDtoList = cityService.getAllCities(page, size);
        return Response.ok().entity(cityResponseDtoList).build();
    }


    @POST
    public Response createCity(CityRequestDto cityRequestDto){
        cityService.createCity(cityRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("{cityId}")
    @GET
    public Response getCity(@PathParam("cityId") int cityId){
        CityResponseDto cityResponseDto = cityService.getOneCity(cityId);
        return Response.ok().entity(cityResponseDto).build();
    }

    @Path("{cityId}")
    @PUT
    public Response updateAddress(@PathParam("cityId") int cityId, CityRequestDto cityRequestDto){
        cityService.updateCity(cityId, cityRequestDto);
        return Response.noContent().build();
    }

    @Path("{cityId}")
    @DELETE
    public Response deleteAddress(@PathParam("cityId") int cityId){
        cityService.deleteCity(cityId);
        return Response.noContent().build();
    }
}
