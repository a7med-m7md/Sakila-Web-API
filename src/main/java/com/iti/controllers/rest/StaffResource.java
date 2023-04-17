package com.iti.controllers.rest;

import com.iti.mappers.StaffMapper;
import com.iti.models.request.StaffRequestDto;
import com.iti.models.request.StoreRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.models.response.StoreResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.StaffRepository;
import com.iti.services.StaffService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Path("staffs")
public class StaffResource {
    StaffService staffService;
    public StaffResource(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        staffService = new StaffService(
                new StaffRepository(entityManager),
                Mappers.getMapper(StaffMapper.class));
    }


    @GET
    public Response getAllStaff(@DefaultValue("1") @QueryParam("page") int page,
                                @DefaultValue("10") @QueryParam("size") int size){
        List<StaffResponseDto> staffResponseDtoList = staffService.findAll(page, size);
        return Response.ok().entity(staffResponseDtoList).build();
    }

    @POST
    public Response createStore(StaffRequestDto staffRequestDto){
        staffService.save(staffRequestDto);
        return Response.noContent().build();
    }


    @Path("{staffId}")
    @GET
    public Response getOneStore(@PathParam("staffId") int staffId){
        StaffResponseDto staffResponseDto = staffService.findById(staffId);
        return Response.ok().entity(staffResponseDto).build();
    }


    @PUT
    @Path("{staffId}")
    public Response updateStore(@PathParam("staffId") int staffId, StaffRequestDto staffRequestDto){
        staffService.update(staffRequestDto, staffId);
        return Response.noContent().build();
    }


    @Path("{staffId}")
    @DELETE
    public Response deleteStore(@PathParam("staffId") int staffId){
        staffService.deleteById(staffId);
        return Response.noContent().build();
    }

}
