package com.iti.mappers;

import com.iti.models.response.CustomerResponseDetailsDto;
import com.iti.persistence.entities.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerDetailsMapper {
    Customer toEntity(CustomerResponseDetailsDto customerResponseDetailsDto);

    CustomerResponseDetailsDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerResponseDetailsDto customerResponseDetailsDto, @MappingTarget Customer customer);

    @AfterMapping
    default void linkPayments(@MappingTarget Customer customer) {
        customer.getPayments().forEach(payment -> payment.setCustomer(customer));
    }

    @AfterMapping
    default void linkRentals(@MappingTarget Customer customer) {
        customer.getRentals().forEach(rental -> rental.setCustomer(customer));
    }
}