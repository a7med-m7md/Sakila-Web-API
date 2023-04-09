package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Payment} entity
 */
@AllArgsConstructor
@Getter
public class PaymentDto implements Serializable {
    private final Integer id;
    @NotNull
    private final BigDecimal amount;
    @NotNull
    private final Instant paymentDate;
    private final Instant lastUpdate;
}