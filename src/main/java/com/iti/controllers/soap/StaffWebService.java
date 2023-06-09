package com.iti.controllers.soap;

import java.util.List;

import com.iti.controllers.soap.exceptions.SoapException;
import com.iti.mappers.StaffMapper;
import com.iti.models.request.StaffRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.repository.StaffRepository;
import com.iti.services.StaffService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import org.mapstruct.factory.Mappers;

@WebService(name = "StaffService")
public class StaffWebService {
    private StaffService staffService;

    public StaffWebService() {
        EntityManager entityManager = JPAFactoryManager.createEntityManager();
        staffService = new StaffService(
                new StaffRepository(entityManager),
                Mappers.getMapper(StaffMapper.class));
    }

    @WebMethod
    @WebResult(name = "staffResponseDto")
    public List<StaffResponseDto> getAllStaff() {
        try {
            return staffService.findAll(1, 10);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod(operationName = "createStaff")
    public void createStaff(@WebParam(name = "staffRequestDto") StaffRequestDto staffRequestDto) {
        try {
            staffService.save(staffRequestDto);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod(operationName = "getStaffById")
    @WebResult(name = "staffResponseDto")
    public StaffResponseDto getStaffById(@WebParam(name = "staffId") int staffId) {
        try {
            return staffService.findById(staffId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod(operationName = "updateStaff")
    public void updateStaff(@WebParam(name = "staffId") int staffId,
                            @WebParam(name = "staffRequestDto") StaffRequestDto staffRequestDto) {
        try {
            staffService.update(staffRequestDto, staffId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }

    @WebMethod(operationName = "deleteStaffById")
    public void deleteStaffById(@WebParam(name = "staffId") int staffId) {
        try {
            staffService.deleteById(staffId);
        } catch (Exception exception) {
            throw new SoapException(exception.getMessage());
        }
    }
}
