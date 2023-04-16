package com.iti.mappers;

import com.iti.models.request.PaymentRequestDto;
import com.iti.models.response.PaymentResponseDto;
import com.iti.persistence.entities.Payment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface PaymentResponseMapper extends BaseMapper<Payment, PaymentRequestDto, PaymentResponseDto> {

    @Mapping(source = "rentalId", target = "rental.id")
    @Mapping(source = "staffId", target = "staff.id")
    @Mapping(source = "customerId", target = "customer.id")
    Payment toEntity(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto toDto(Payment payment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentRequestDto paymentRequestDto, @MappingTarget Payment payment);
}