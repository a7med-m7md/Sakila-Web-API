package com.iti.services;

import com.iti.mappers.BaseMapper;
import com.iti.models.request.StaffRequestDto;
import com.iti.models.response.StaffResponseDto;
import com.iti.persistence.entities.Staff;
import com.iti.persistence.repository.BaseRepository;

public class StaffService extends BaseService<StaffRequestDto, StaffResponseDto, Staff>{
    public StaffService(BaseRepository<Staff> repository,
                         BaseMapper mapper) {
        super(repository, mapper);
    }
}
