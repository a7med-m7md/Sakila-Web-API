package com.iti.controllers.rest;


import com.iti.mappers.StoreMapper;
import com.iti.models.request.StoreRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.models.response.StoreResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.StoreRepository;
import com.iti.services.StoreService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Path("stores")
public class StoreResource {
    StoreService storeService;
    public StoreResource(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        storeService = new StoreService(new StoreRepository(entityManager), Mappers.getMapper(StoreMapper.class));
    }
    @GET
    public Response getAllStores(@DefaultValue("1") @QueryParam("page") int page,
                                 @DefaultValue("10") @QueryParam("size") int size){
        List<StoreResponseDto> storeResponseDtoList = storeService.findAll(page, size);
        return Response.ok().entity(storeResponseDtoList).build();
    }

    @POST
    public Response createStore(StoreRequestDto storeRequestDto){
        storeService.save(storeRequestDto);
        return Response.noContent().build();
    }


    @Path("{storeId}")
    @GET
    public Response getOneStore(@PathParam("storeId") int storeId){
        StoreResponseDto storeResponseDto = storeService.findById(storeId);
        return Response.ok().entity(storeResponseDto).build();
    }

    //todo there is an error here in mapper should be implemented
    @PUT
    @Path("{storeId}")
    public Response updateStore(@PathParam("storeId") int storeId, StoreRequestDto storeRequestDto){
        storeService.update(storeRequestDto, storeId);
        return Response.noContent().build();
    }


    @Path("{storeId}")
    @DELETE
    public Response deleteStore(@PathParam("storeId") int storeId){
        storeService.deleteById(storeId);
        return Response.noContent().build();
    }

    /// Staffs
    @Path("{storeId}/staffs")
    @GET
    public Response getAllStaffsInStore(@PathParam("storeId") int storeId){
        List<StaffResponseDto> staffResponseDtoList = storeService.getStoreStaff(storeId);
        return Response.ok().entity(staffResponseDtoList).build();
    }

    @Path("{storeId}/staffs/{staffId}")
    @GET
    public Response getAllStaffsInStore(@PathParam("storeId") int storeId, @PathParam("staffId") int staffId){
        StaffResponseDto staff = storeService.getOneStaffInStore(storeId, staffId);
        return Response.ok().entity(staff).build();
    }
}
