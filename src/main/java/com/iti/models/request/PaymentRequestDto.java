package com.iti.models.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.iti.persistence.entities.Payment} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequestDto implements Serializable {
    private Integer customerId;
    private Short staffId;
    private Integer rentalId;
    @NotNull
    private BigDecimal amount;
}