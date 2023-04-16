package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Payment} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentResponseDto implements Serializable {
    private Integer id;
    private Integer customerId;
    private Short staffId;
    private Integer rentalId;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Instant paymentDate;
    private Instant lastUpdate;
}