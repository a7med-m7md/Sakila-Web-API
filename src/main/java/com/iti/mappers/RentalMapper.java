package com.iti.mappers;

import com.iti.models.request.RentalRequestDto;
import com.iti.models.response.RentalResponseDto;
import com.iti.persistence.entities.Rental;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface RentalMapper extends BaseMapper<Rental, RentalRequestDto, RentalResponseDto>{
    Rental toEntity(RentalResponseDto rentalResponseDto);

    RentalResponseDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rental partialUpdate(RentalResponseDto rentalResponseDto, @MappingTarget Rental rental);
}