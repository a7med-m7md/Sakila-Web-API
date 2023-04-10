package com.iti.mappers;

import com.iti.models.response.CustomerResponseDto;
import com.iti.persistence.entities.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerMapper {
    Customer toEntity(CustomerResponseDto customerResponseDto);

    CustomerResponseDto toDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerResponseDto customerResponseDto, @MappingTarget Customer customer);
}