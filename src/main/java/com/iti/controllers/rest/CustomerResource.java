package com.iti.controllers.rest;

import com.iti.models.response.CustomerResponseDetailsDto;
import com.iti.models.response.CustomerResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Customer;
import com.iti.services.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {
    private CustomerService customerService;
    public CustomerResource(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        customerService = new CustomerService(entityManager);
    }
    @GET
    public Response getAllCustomers(@DefaultValue("10") @QueryParam("size") int size,
                                    @DefaultValue("1") @QueryParam("size")  int page){
        List<CustomerResponseDto> customers = customerService.findAllCustomers(page, size);
        return Response.ok().entity(customers).build();
    }

    @Path("{customerId}")
    @GET
    public Response getOneCustomer(@PathParam("customerId") int customerId){
        CustomerResponseDto customerResourceDto = customerService.getCustomer(customerId);
        return Response.ok().entity(customerResourceDto).build();
    }

    @Path("{customerId}/details")
    @GET
    public Response getCustomerDetails(@PathParam("customerId") int customerId){
        CustomerResponseDetailsDto customerResponseDetailsDto = customerService.getCustomerDetails(customerId);
        return Response.ok().entity(customerResponseDetailsDto).build();
    }

}
