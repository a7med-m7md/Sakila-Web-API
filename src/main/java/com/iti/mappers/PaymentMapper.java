package com.iti.mappers;

import com.iti.models.dtos.PaymentResponseDto;
import com.iti.persistence.entities.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface PaymentMapper {
    Payment toEntity(PaymentResponseDto paymentResponseDto);

    PaymentResponseDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentResponseDto paymentResponseDto, @MappingTarget Payment payment);
}