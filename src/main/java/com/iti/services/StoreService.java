package com.iti.services;

import com.iti.mappers.BaseMapper;
import com.iti.mappers.StaffMapper;
import com.iti.models.request.StaffRequestDto;
import com.iti.models.request.StoreRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.models.response.StoreResponseDto;
import com.iti.persistence.entities.Payment;
import com.iti.persistence.entities.Staff;
import com.iti.persistence.entities.Store;
import com.iti.persistence.repository.BaseRepository;
import com.iti.persistence.repository.StaffRepository;
import com.iti.persistence.repository.StoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.jar.JarEntry;
import java.util.stream.Collectors;

public class StoreService extends BaseService<StoreRequestDto, StoreResponseDto, Store> {
    BaseRepository<Store> repository;

    public StoreService(BaseRepository<Store> repository, BaseMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

    public List<StaffResponseDto> getStoreStaff(int storeId) {
        StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
        List<StaffResponseDto> staffResponseDtoList;
        Optional<Store> optionalStore = repository.findOne(storeId);
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();
            Set<Staff> staffList = store.getStaff();
            staffResponseDtoList = staffList.stream().map(staffMapper::toDto).collect(Collectors.toList());
            return staffResponseDtoList;
        }
        return null;
    }

    public StaffResponseDto getOneStaffInStore(int storeId, int staffId) {
        String query = "SELECT s FROM Staff s WHERE s.store.id = " + storeId + " AND s.id = " + staffId;

        StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
        List<Object> staffs = repository.findByNamedQuery(query);
        StaffResponseDto staffResult = staffs.stream()
                .map(staff -> (Staff) staff)
                .map(staff -> staffMapper.toDto(staff))
                .findFirst().get();

        return staffResult;
    }

}
