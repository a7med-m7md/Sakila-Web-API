package com.iti.services;

import com.iti.mappers.CustomerDetailsMapper;
import com.iti.mappers.CustomerMapper;
import com.iti.models.dtos.CustomerDto;
import com.iti.models.response.CustomerResponseDetailsDto;
import com.iti.models.response.CustomerResponseDto;
import com.iti.persistence.entities.Customer;
import com.iti.persistence.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


}
