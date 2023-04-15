package com.iti.mappers;

import com.iti.models.response.AddressResponseDto;
import com.iti.persistence.entities.Address;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface AddressMapper {
    Address toEntity(AddressResponseDto addressResponseDto);

    AddressResponseDto toDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address partialUpdate(AddressResponseDto addressResponseDto, @MappingTarget Address address);
}