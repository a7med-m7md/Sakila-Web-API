package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Customer} entity
 */
@AllArgsConstructor
@Getter
public class CustomerDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
    @Size(max = 50)
    private final String email;
    @NotNull
    private final Boolean active;
    @NotNull
    private final Instant createDate;
    private final Instant lastUpdate;
    private final Set<PaymentDto> payments;
    private final Set<RentalDto> rentals;
}