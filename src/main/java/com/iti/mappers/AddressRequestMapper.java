package com.iti.mappers;

import com.iti.models.request.AddressRequestDto;
import com.iti.persistence.entities.Address;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface AddressRequestMapper {
    @Mapping(source = "cityId", target = "city.id")
    Address toEntity(AddressRequestDto addressRequestDto);

    @Mapping(source = "city.id", target = "cityId")
    AddressRequestDto toDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "cityId", target = "city.id")
    Address partialUpdate(AddressRequestDto addressRequestDto, @MappingTarget Address address);
}