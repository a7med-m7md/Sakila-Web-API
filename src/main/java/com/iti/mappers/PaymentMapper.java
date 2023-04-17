package com.iti.mappers;

import com.iti.models.response.AddressResponseDto;
import com.iti.persistence.entities.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface PaymentMapper {
    Payment toEntity(AddressResponseDto.PaymentResponseDto paymentResponseDto);

    AddressResponseDto.PaymentResponseDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(AddressResponseDto.PaymentResponseDto paymentResponseDto, @MappingTarget Payment payment);
}