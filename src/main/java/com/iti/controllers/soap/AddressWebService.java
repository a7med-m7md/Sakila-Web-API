package com.iti.controllers.soap;

import com.iti.controllers.soap.exceptions.SoapException;
import com.iti.models.request.AddressRequestDto;
import com.iti.models.response.AddressResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.services.AddressService;
import jakarta.persistence.EntityManager;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class AddressWebService {
    private AddressService addressService;

    public AddressWebService() {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        addressService = new AddressService(entityManager);
    }

    @WebMethod
    public List<AddressResponseDto> getAllAddresses(
            @WebParam(name = "page") int page, @WebParam(name = "size") int size) {
        if (page == 0 || size == 0) {
            page = 1;
            size = 10;
        }
        try {
            return addressService.getAllAddresses(page, size);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void createAddress(@WebParam(name = "addressRequestDto") AddressRequestDto addressRequestDto) {
        try {
            addressService.createAddress(addressRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public AddressResponseDto getAddress(@WebParam(name = "addressId") int addressId) {
        try {
            return addressService.getOneAddress(addressId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void updateAddress(@WebParam(name = "addressId") int addressId, @WebParam(name = "addressRequestDto") AddressRequestDto addressRequestDto) {
        try {
            addressService.updateAddress(addressId, addressRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void deleteAddress(@WebParam(name = "addressId") int addressId) {
        try {
            addressService.deleteAddress(addressId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }
}
