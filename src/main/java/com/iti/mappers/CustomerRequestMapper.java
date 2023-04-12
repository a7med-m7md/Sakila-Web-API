package com.iti.mappers;

import com.iti.models.request.CustomerRequestDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Address;
import com.iti.persistence.entities.Customer;
import com.iti.persistence.entities.Store;
import com.iti.persistence.repository.AddressRepository;
import com.iti.persistence.repository.StoreRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CustomerRequestMapper {
    EntityManager entityManager = JPAFactoryManager.createEntityManager();

    @Mapping(target = "store", source = "storeId", qualifiedByName = "mapStore")
    @Mapping(target = "address", source = "addressId", qualifiedByName = "mapAddress")
    Customer toEntity(CustomerRequestDto customerRequestDto);

    @Named("mapStore")
    default Store mapStore(Short storeId){
        if(storeId == null)
            return null;
        StoreRepository storeRepository = new StoreRepository(entityManager);
        return storeRepository.findOne(storeId).get();
    }


    @Named("mapAddress")
    default Address mapAddress(Short addressId){
        if(addressId == null)
            return null;
        AddressRepository addressRepository = new AddressRepository(entityManager);
        return addressRepository.findOne(addressId).get();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerRequestDto customerRequestDto, @MappingTarget Customer customer);
}