package com.iti.services;

import com.iti.mappers.AddressMapper;
import com.iti.models.request.AddressRequestDto;
import com.iti.mappers.AddressRequestMapper;
import com.iti.models.response.AddressResponseDto;
import com.iti.persistence.entities.Address;
import com.iti.persistence.repository.AddressRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressService extends AddressRepository<Address> {
    AddressMapper addressMapper;

    public AddressService(EntityManager entityManager) {
        super(entityManager);
        addressMapper = Mappers.getMapper(AddressMapper.class);
    }

    public List<AddressResponseDto> getAllAddresses(int page, int size) {
        List<AddressResponseDto> addressResponseDtoList = new ArrayList<>();
        List<Address> addresses = findAll(page, size);
        for (Address address : addresses) {
            AddressResponseDto addressResponseDto = addressMapper.toDto(address);
            addressResponseDtoList.add(addressResponseDto);
        }
        return addressResponseDtoList;
    }

    public void createAddress(AddressRequestDto addressRequestDto) {
        AddressRequestMapper addressRequestMapper = Mappers.getMapper(AddressRequestMapper.class);
        Address address = addressRequestMapper.toEntity(addressRequestDto);
        create(address);
    }


    public AddressResponseDto getOneAddress(int addressId) {
        Optional<Address> optionalAddress = findOne(addressId);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            AddressResponseDto addressResponseDto = addressMapper.toDto(address);
            return addressResponseDto;
        }
        return null;
    }

    public void updateAddress(int addressId, AddressRequestDto addressRequestDto) {
        AddressRequestMapper addressRequestMapper = Mappers.getMapper(AddressRequestMapper.class);
        Optional<Address> optionalAddress = findOne(addressId);
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            Address updatedAddress = addressRequestMapper.partialUpdate(addressRequestDto, address);
            update(updatedAddress);
        }
    }

    public void deleteAddress(int addressId) {
        Optional<Address> optionalAddress = findOne(addressId);
        if(optionalAddress.isPresent()){
            Address address = optionalAddress.get();
            deleteById(address);
        }
    }

}
