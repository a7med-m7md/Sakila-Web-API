package com.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Rental} entity
 */
@AllArgsConstructor
@Getter
public class RentalDto implements Serializable {
    private final Integer id;
    @NotNull
    private final Instant rentalDate;
    private final Instant returnDate;
    @NotNull
    private final Instant lastUpdate;
}