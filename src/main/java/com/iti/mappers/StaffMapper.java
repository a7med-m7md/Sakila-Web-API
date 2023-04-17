package com.iti.mappers;

import com.iti.models.request.StaffRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.persistence.entities.Staff;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface StaffMapper extends BaseMapper<Staff, StaffRequestDto,StaffResponseDto>{
    Staff toEntity(StaffRequestDto staffRequestDto);

    StaffResponseDto toDto(Staff staff);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff partialUpdate(StaffRequestDto staffRequestDto, @MappingTarget Staff staff);
}