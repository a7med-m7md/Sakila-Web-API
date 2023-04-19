package com.iti.mappers;

import com.iti.models.request.StoreRequestDto;
import com.iti.models.response.StoreResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Address;
import com.iti.persistence.entities.Staff;
import com.iti.persistence.entities.Store;
import com.iti.persistence.repository.AddressRepository;
import com.iti.persistence.repository.StaffRepository;
import com.iti.persistence.repository.StoreRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StoreMapper extends BaseMapper<Store, StoreRequestDto, StoreResponseDto>{
    EntityManager entityManager = JPAFactoryManager.createEntityManager();
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "managerStaffId", target = "managerStaff.id")
    Store toEntity(StoreRequestDto storeRequestDto);

    StoreResponseDto toDto(Store store);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "addressId", target = "address", qualifiedByName = "mapAddress")
    @Mapping(source = "managerStaffId", target = "managerStaff", qualifiedByName = "mapStaffManager")
    Store partialUpdate(StoreRequestDto storeRequestDto, @MappingTarget Store store);


    @Named("mapStaffManager")
    default Staff mapStaffManager(Short managerStaffId){
        if(managerStaffId == null)
            return null;
        StaffRepository staffRepository = new StaffRepository(entityManager);
        return staffRepository.findOne(managerStaffId).get();
    }


    @Named("mapAddress")
    default Address mapAddress(Integer addressId){
        if(addressId == null)
            return null;
        AddressRepository<Address> addressRepository = new AddressRepository(entityManager);
        return addressRepository.findOne(addressId).get();
    }
}