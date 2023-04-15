package com.iti.mappers;

import com.iti.models.response.CityResponseDto;
import com.iti.persistence.entities.City;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CityMapper  {
    City toEntity(CityResponseDto cityResponseDto);

    CityResponseDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityResponseDto cityResponseDto, @MappingTarget City city);
}