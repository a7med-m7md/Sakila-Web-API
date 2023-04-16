package com.iti.services;

import com.iti.mappers.BaseMapper;
import com.iti.models.request.PaymentRequestDto;
import com.iti.models.response.PaymentResponseDto;
import com.iti.persistence.entities.Payment;
import com.iti.persistence.repository.BaseRepository;

public class PaymentService extends BaseService<PaymentRequestDto, PaymentResponseDto, Payment>{
    public PaymentService(BaseRepository<Payment> repository, BaseMapper mapper) {
        super(repository, mapper);
    }
}
