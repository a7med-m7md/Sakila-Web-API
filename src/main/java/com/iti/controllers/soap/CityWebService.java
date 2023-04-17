package com.iti.controllers.soap;

import com.iti.models.request.CityRequestDto;
import com.iti.models.response.CityResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.services.CityService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;

import java.util.List;

@WebService(name = "CityService", targetNamespace = "http://www.example.com/location")
public class CityWebService {
    private CityService cityService;

    public CityWebService() {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        cityService = new CityService(entityManager);
    }

    @WebMethod
    public List<CityResponseDto> getAllCities(@WebParam(name = "page") int page, @WebParam(name = "size") int size) {
        if(page == 0 || size == 0){
            page = 1;
            size = 10;
        }
        List<CityResponseDto> cityResponseDtoList = cityService.getAllCities(page, size);
        return cityResponseDtoList;
    }

    @WebMethod
    public void createCity(@WebParam(name = "city") CityRequestDto cityRequestDto) {
        cityService.createCity(cityRequestDto);
    }

    @WebMethod
    public CityResponseDto getCity(@WebParam(name = "cityId") int cityId) {
        return cityService.getOneCity(cityId);
    }

    @WebMethod
    public void updateCity(@WebParam(name = "cityId") int cityId, @WebParam(name = "city") CityRequestDto cityRequestDto) {
        cityService.updateCity(cityId, cityRequestDto);
    }

    @WebMethod
    public void deleteCity(@WebParam(name = "cityId") int cityId) {
        cityService.deleteCity(cityId);
    }
}
