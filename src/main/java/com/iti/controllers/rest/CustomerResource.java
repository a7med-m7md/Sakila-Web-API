package com.iti.controllers.rest;

import com.iti.models.request.CustomerRequestDto;
import com.iti.models.response.AddressResponseDto;
import com.iti.models.response.CustomerRentalResponseDto;
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

    @POST
    public Response createCustomer(CustomerRequestDto customerRequestDto){
        customerService.createCustomer(customerRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @Path("{customerId}")
    @GET
    public Response getOneCustomer(@PathParam("customerId") int customerId){
        CustomerResponseDto customerResourceDto = customerService.getCustomer(customerId);
        return Response.ok().entity(customerResourceDto).build();
    }

    @Path("{customerId}")
    @PUT
    public Response updateCustomer(@PathParam("customerId") int customerId, CustomerRequestDto customerRequestDto){
        customerService.updateCustomer(customerId, customerRequestDto);
        return Response.noContent().build();
    }

    @Path("{customerId}")
    @DELETE
    public Response deleteCustomer(@PathParam("customerId") int customerId){
        customerService.deleteCustomer(customerId);
        return Response.noContent().build();
    }

    @Path("{customerId}/details")
    @GET
    public Response getCustomerDetails(@PathParam("customerId") int customerId){
        CustomerResponseDetailsDto customerResponseDetailsDto = customerService.getCustomerDetails(customerId);
        return Response.ok().entity(customerResponseDetailsDto).build();
    }

    // rentals
    @Path("{customerId}/rentals")
    @GET
    public Response getCustomerRentals(@PathParam("customerId") int customerId){
        List<CustomerRentalResponseDto> customerRentalResponseDto = customerService.getCustomerRentals(customerId);
        return Response.ok().entity(customerRentalResponseDto).build();
    }

    // payment
    @Path("{customerId}/payments")
    @GET
    public Response getCustomerPayments(@PathParam("customerId") int customerId){
        List<AddressResponseDto.PaymentResponseDto> paymentResponseDtos = customerService.getCustomerPayments(customerId);
        return Response.ok().entity(paymentResponseDtos).build();
    }

}
