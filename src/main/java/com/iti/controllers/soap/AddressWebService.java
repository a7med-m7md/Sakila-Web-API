package com.iti.controllers.soap;

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

    public AddressWebService(){
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        addressService = new AddressService(entityManager);
    }

    @WebMethod
    public List<AddressResponseDto> getAllAddresses(
            @WebParam(name = "page") int page, @WebParam(name = "size") int size){
        if(page == 0 || size == 0){
            page = 1;
            size = 10;
        }
        return addressService.getAllAddresses(page, size);
    }

    @WebMethod
    public void createAddress(@WebParam(name = "addressRequestDto") AddressRequestDto addressRequestDto){
        addressService.createAddress(addressRequestDto);
    }

    @WebMethod
    public AddressResponseDto getAddress(@WebParam(name = "addressId") int addressId){
        return addressService.getOneAddress(addressId);
    }

    @WebMethod
    public void updateAddress(@WebParam(name = "addressId") int addressId, @WebParam(name = "addressRequestDto") AddressRequestDto addressRequestDto){
        addressService.updateAddress(addressId, addressRequestDto);
    }

    @WebMethod
    public void deleteAddress(@WebParam(name = "addressId") int addressId){
        addressService.deleteAddress(addressId);
    }
}
