package com.iti.controllers.soap;
import com.iti.models.request.CustomerRequestDto;
import com.iti.models.response.AddressResponseDto;
import com.iti.models.response.CustomerRentalResponseDto;
import com.iti.models.response.CustomerResponseDetailsDto;
import com.iti.models.response.CustomerResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Customer;
import com.iti.services.CustomerService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;

import java.util.List;

@WebService
public class CustomerWebService {
    private CustomerService customerService;

    public CustomerWebService(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        customerService = new CustomerService(entityManager);
    }

    @WebMethod
    public List<CustomerResponseDto> getAllCustomers(@WebParam(name = "size") int size,
                                                     @WebParam(name = "page") int page){
        if(page == 0 || size == 0){
            page = 1;
            size = 10;
        }
        return customerService.findAllCustomers(page, size);
    }

    @WebMethod
    public void createCustomer(@WebParam(name = "customerRequestDto") CustomerRequestDto customerRequestDto){
        customerService.createCustomer(customerRequestDto);
    }

    @WebMethod
    public CustomerResponseDto getOneCustomer(@WebParam(name = "customerId") int customerId){
        return customerService.getCustomer(customerId);
    }

    @WebMethod
    public void updateCustomer(@WebParam(name = "customerId") int customerId,
                               @WebParam(name = "customerRequestDto") CustomerRequestDto customerRequestDto){
        customerService.updateCustomer(customerId, customerRequestDto);
    }

    @WebMethod
    public void deleteCustomer(@WebParam(name = "customerId") int customerId){
        customerService.deleteCustomer(customerId);
    }

    @WebMethod
    public CustomerResponseDetailsDto getCustomerDetails(@WebParam(name = "customerId") int customerId){
        return customerService.getCustomerDetails(customerId);
    }

    @WebMethod
    public List<CustomerRentalResponseDto> getCustomerRentals(@WebParam(name = "customerId") int customerId){
        return customerService.getCustomerRentals(customerId);
    }

    @WebMethod
    public List<AddressResponseDto.PaymentResponseDto> getCustomerPayments(@WebParam(name = "customerId") int customerId){
        return customerService.getCustomerPayments(customerId);
    }

}
