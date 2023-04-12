package com.iti.services;

import com.iti.mappers.*;
import com.iti.models.dtos.PaymentResponseDto;
import com.iti.models.request.CustomerRequestDto;
import com.iti.models.response.CustomerRentalResponseDto;
import com.iti.models.response.CustomerResponseDetailsDto;
import com.iti.models.response.CustomerResponseDto;
import com.iti.persistence.entities.Actor;
import com.iti.persistence.entities.Customer;
import com.iti.persistence.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService extends CustomerRepository<Customer> {
    private CustomerMapper customerMapper;
    public CustomerService(EntityManager entityManager) {
        super(entityManager);
        customerMapper = Mappers.getMapper(CustomerMapper.class);
    }

    public List<CustomerResponseDto> findAllCustomers(int size, int page) {
        List<Customer> customers = findAll(size, page);
        List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
        for (Customer customer: customers){
            CustomerResponseDto customerResponseDto = customerMapper.toDto(customer);
            customerResponseDtos.add(customerResponseDto);
        }
        return customerResponseDtos;
    }

    public CustomerResponseDto getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = findOne(customerId);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            CustomerResponseDto customerResponseDto = customerMapper.toDto(customer);
            return customerResponseDto;
        }
        return null;
    }

    public CustomerResponseDetailsDto getCustomerDetails(int customerId) {
        Optional<Customer> optionalCustomer = findOne(customerId);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            CustomerDetailsMapper customerDetailsMapper = Mappers.getMapper(CustomerDetailsMapper.class);
            CustomerResponseDetailsDto customerResponseDetailsDto = customerDetailsMapper.toDto(customer);
            return customerResponseDetailsDto;
        }
        return null;
    }


    public List<CustomerRentalResponseDto> getCustomerRentals(int customerId) {
        Optional<Customer> optionalCustomer = findOne(customerId);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            CustomerRentalMapper customerRentalMapper = Mappers.getMapper(CustomerRentalMapper.class);

            List<CustomerRentalResponseDto> customerRentalResponseDto = customer.getRentals().stream()
                    .map(rental -> customerRentalMapper.toDto(rental)).collect(Collectors.toList());
            return customerRentalResponseDto;
        }
        return null;
    }

    public List<PaymentResponseDto> getCustomerPayments(int customerId) {
        Optional<Customer> optionalCustomer = findOne(customerId);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            PaymentMapper paymentMapper = Mappers.getMapper(PaymentMapper.class);

            List<PaymentResponseDto> paymentResponseDtos = customer.getPayments().stream()
                    .map(payment -> paymentMapper.toDto(payment)).collect(Collectors.toList());
            return paymentResponseDtos;
        }
        return null;
    }

    public void createCustomer(CustomerRequestDto customerRequestDto) {
        CustomerRequestMapper customerRequestMapper = Mappers.getMapper(CustomerRequestMapper.class);
        Customer customer = customerRequestMapper.toEntity(customerRequestDto);
        create(customer);
    }

    public void updateCustomer(int customerId, CustomerRequestDto updatedCustomer) {
        Optional<Customer> optionalCustomer = findOne(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            if (updatedCustomer.getFirstName() != null)
                customer.setFirstName(updatedCustomer.getFirstName());
            if (updatedCustomer.getLastName() != null)
                customer.setLastName(updatedCustomer.getLastName());
            if(updatedCustomer.getEmail() != null)
                customer.setEmail(updatedCustomer.getEmail());
            update(customer);
        }
    }

    public void deleteCustomer(int customerId) {
        Optional<Customer> optionalCustomer = findOne(customerId);
        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            deleteById(customer);
        }
    }
}
