package com.iti.models.response;

import com.iti.models.dtos.PaymentResponseDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Rental} entity
 */
@AllArgsConstructor
@Getter
public class CustomerRentalResponseDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Instant rentalDate;
    @NotNull
    private final InventoryDto inventory;
    private final Instant returnDate;
    private final Set<PaymentResponseDto> payments;

    private final FilmResponseDto film;

}