package com.iti.mappers;

import com.iti.models.request.StoreRequestDto;
import com.iti.models.response.StoreResponseDto;
import com.iti.persistence.entities.Store;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StoreMapper extends BaseMapper<Store, StoreRequestDto, StoreResponseDto>{
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "managerStaffId", target = "managerStaff.id")
    Store toEntity(StoreRequestDto storeRequestDto);

    StoreResponseDto toDto(Store store);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Store partialUpdate(StoreRequestDto storeRequestDto, @MappingTarget Store store);
}