package com.iti.controllers.soap;

import com.iti.controllers.soap.exceptions.SoapException;
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

    public CustomerWebService() {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        customerService = new CustomerService(entityManager);
    }

    @WebMethod
    public List<CustomerResponseDto> getAllCustomers(@WebParam(name = "size") int size,
                                                     @WebParam(name = "page") int page) {
        if (page == 0 || size == 0) {
            page = 1;
            size = 10;
        }
        try {
            return customerService.findAllCustomers(page, size);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void createCustomer(@WebParam(name = "customerRequestDto") CustomerRequestDto customerRequestDto) {
        try {
            customerService.createCustomer(customerRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public CustomerResponseDto getOneCustomer(@WebParam(name = "customerId") int customerId) {
        try {
            return customerService.getCustomer(customerId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void updateCustomer(@WebParam(name = "customerId") int customerId,
                               @WebParam(name = "customerRequestDto") CustomerRequestDto customerRequestDto) {
        try {
            customerService.updateCustomer(customerId, customerRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void deleteCustomer(@WebParam(name = "customerId") int customerId) {
        try {
            customerService.deleteCustomer(customerId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public CustomerResponseDetailsDto getCustomerDetails(@WebParam(name = "customerId") int customerId) {
        try {
            return customerService.getCustomerDetails(customerId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public List<CustomerRentalResponseDto> getCustomerRentals(@WebParam(name = "customerId") int customerId) {
        try {
            return customerService.getCustomerRentals(customerId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public List<AddressResponseDto.PaymentResponseDto> getCustomerPayments(@WebParam(name = "customerId") int customerId) {
        try {
            return customerService.getCustomerPayments(customerId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }

    }

}
