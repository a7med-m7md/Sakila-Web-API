package com.iti.mappers;

import com.iti.models.request.PaymentRequestDto;
import com.iti.models.response.PaymentResponseDto;
import com.iti.persistence.entities.Payment;
import org.mapstruct.MappingTarget;

public interface BaseMapper<Table, RequestDTO, ResponseDTO> {
    ResponseDTO toDTO(Table table);
    Table toEntity(RequestDTO dto);
    Table partialUpdate(RequestDTO requestDto, @MappingTarget Table entity);
}
