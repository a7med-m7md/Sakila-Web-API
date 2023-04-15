package com.iti.services;

import com.iti.mappers.AddressRequestMapper;
import com.iti.mappers.CityMapper;
import com.iti.mappers.CityRequestMapper;
import com.iti.models.request.CityRequestDto;
import com.iti.models.response.AddressResponseDto;
import com.iti.models.response.CityResponseDto;
import com.iti.persistence.entities.Address;
import com.iti.persistence.entities.City;
import com.iti.persistence.repository.CityRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityService extends CityRepository<City> {
    CityMapper cityMapper;
    public CityService(EntityManager entityManager) {
        super(entityManager);
        cityMapper = Mappers.getMapper(CityMapper.class);
    }

    public List<CityResponseDto> getAllCities(int page, int size) {
        List<CityResponseDto> cityResponseDtoList = new ArrayList<>();
        List<City> cities = findAll(page, size);
        for (City city: cities) {
            CityResponseDto cityResponseDto = cityMapper.toDto(city);
            cityResponseDtoList.add(cityResponseDto);
        }
        return cityResponseDtoList;
    }

    public void createCity(CityRequestDto cityRequestDto) {
        CityRequestMapper cityRequestMapper = Mappers.getMapper(CityRequestMapper.class);
        City city = cityRequestMapper.toEntity(cityRequestDto);
        create(city);
    }

    public CityResponseDto getOneCity(int cityId) {
        Optional<City> optionalCity = findOne(cityId);
        if (optionalCity.isPresent()) {
            City city = optionalCity.get();
            CityResponseDto cityResponseDto = cityMapper.toDto(city);
            return cityResponseDto;
        }
        return null;
    }

    public void updateCity(int cityId, CityRequestDto cityRequestDto) {
        CityRequestMapper cityRequestMapper = Mappers.getMapper(CityRequestMapper.class);
        Optional<City> optionalCity = findOne(cityId);
        if(optionalCity.isPresent()){
            City city = optionalCity.get();
            City updatedCity = cityRequestMapper.partialUpdate(cityRequestDto, city);
            update(updatedCity);
        }
    }

    public void deleteCity(int cityId) {
        Optional<City> optionalCity = findOne(cityId);
        if(optionalCity.isPresent()){
            City city = optionalCity.get();
            deleteById(city);
        }
    }
}
