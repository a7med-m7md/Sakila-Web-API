package com.iti.mappers;

import com.iti.models.response.CustomerRentalResponseDto;
import com.iti.persistence.entities.Rental;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerRentalMapper {
    Rental toEntity(CustomerRentalResponseDto customerRentalResponseDto);

    @Mapping(target = "film", source = "rental.inventory.film")
    CustomerRentalResponseDto toDto(Rental rental);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(CustomerRentalResponseDto customerRentalResponseDto, @MappingTarget Rental rental);
}