package com.iti.mappers;

import com.iti.models.request.CityRequestDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.City;
import com.iti.persistence.entities.Country;
import com.iti.persistence.repository.BaseRepository;
import com.iti.persistence.repository.CountryRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CityRequestMapper {

    @Mapping(source = "countryId", target = "country", qualifiedByName = "mapCountry")
    City toEntity(CityRequestDto cityRequestDto);

    @Named("mapCountry")
    default Country mapCountry(Integer countryId){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        CountryRepository countryRepository = new CountryRepository(entityManager);
        return countryRepository.findOne(countryId).get();
    }

    CityRequestDto toDto(City city);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City partialUpdate(CityRequestDto cityRequestDto, @MappingTarget City city);
}