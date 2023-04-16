package com.iti.services;

import com.iti.mappers.BaseMapper;
import com.iti.models.request.RentalRequestDto;
import com.iti.models.response.RentalResponseDto;
import com.iti.persistence.entities.Rental;
import com.iti.persistence.repository.BaseRepository;

public class RentalService extends BaseService<RentalRequestDto, RentalResponseDto, Rental>{
    public RentalService(BaseRepository<Rental> repository, BaseMapper mapper) {
        super(repository, mapper);
    }
}
