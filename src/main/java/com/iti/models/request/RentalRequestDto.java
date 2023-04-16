package com.iti.models.request;

import com.iti.models.response.PaymentResponseDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Rental} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentalRequestDto implements Serializable {
    @NotNull
    private Instant rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    private Instant returnDate;
    private Short staffId;
    @NotNull
    private Instant lastUpdate;
    private Set<PaymentResponseDto> payments = new LinkedHashSet<>();
}