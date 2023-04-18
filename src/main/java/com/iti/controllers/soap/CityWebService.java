package com.iti.controllers.soap;

import com.iti.controllers.soap.exceptions.SoapException;
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
        if (page == 0 || size == 0) {
            page = 1;
            size = 10;
        }
        try {
            List<CityResponseDto> cityResponseDtoList = cityService.getAllCities(page, size);
            return cityResponseDtoList;
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void createCity(@WebParam(name = "city") CityRequestDto cityRequestDto) {
        try {
            cityService.createCity(cityRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public CityResponseDto getCity(@WebParam(name = "cityId") int cityId) {
        try {
            return cityService.getOneCity(cityId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void updateCity(@WebParam(name = "cityId") int cityId, @WebParam(name = "city") CityRequestDto cityRequestDto) {
        try {
            cityService.updateCity(cityId, cityRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void deleteCity(@WebParam(name = "cityId") int cityId) {
        try {
            cityService.deleteCity(cityId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }
}
