package com.iti.controllers.soap;

import com.iti.controllers.soap.exceptions.SoapException;
import com.iti.mappers.StoreMapper;
import com.iti.models.request.StoreRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.models.response.StoreResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Store;
import com.iti.persistence.repository.StoreRepository;
import com.iti.services.StoreService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

import java.util.List;

@WebService
public class StoreWebService {
    private StoreService storeService;

    public StoreWebService() {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        storeService = new StoreService(new StoreRepository(entityManager), Mappers.getMapper(StoreMapper.class));
    }

    @WebMethod
    public List<StoreResponseDto> getAllStores(@WebParam(name = "page") int page, @WebParam(name = "size") int size) {
        try {
            List<StoreResponseDto> storeResponseDtoList = storeService.findAll(page, size);
            return storeResponseDtoList;
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void createStore(@WebParam(name = "storeRequest") StoreRequestDto storeRequestDto) {
        try {
            storeService.save(storeRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public StoreResponseDto getOneStore(@WebParam(name = "storeId") int storeId) {
        try {
            StoreResponseDto storeResponseDto = storeService.findById(storeId);
            return storeResponseDto;
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void updateStore(@WebParam(name = "storeId") int storeId, @WebParam(name = "storeRequest") StoreRequestDto storeRequestDto) {
        try {
            storeService.update(storeRequestDto, storeId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public void deleteStore(@WebParam(name = "storeId") int storeId) {
        try {
            storeService.deleteById(storeId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public List<StaffResponseDto> getAllStaffsInStore(@WebParam(name = "storeId") int storeId) {
        try {
            List<StaffResponseDto> staffResponseDtoList = storeService.getStoreStaff(storeId);
            return staffResponseDtoList;
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod
    public StaffResponseDto getOneStaffInStore(@WebParam(name = "storeId") int storeId, @WebParam(name = "staffId") int staffId) {
        try {
            StaffResponseDto staff = storeService.getOneStaffInStore(storeId, staffId);
            return staff;
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

}
