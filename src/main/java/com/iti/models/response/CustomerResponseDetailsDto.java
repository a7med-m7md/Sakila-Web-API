package com.iti.models.response;

import com.iti.models.dtos.PaymentResponseDto;
import com.iti.models.dtos.RentalDto;
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
public class CustomerResponseDetailsDto implements Serializable {
    @NotNull
    private final StoreDto store;
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
    @Size(max = 50)
    private final String email;
    @NotNull
    private final AddressDto address;
    @NotNull
    private final Boolean active;
    @NotNull
    private final Instant createDate;
    private final Instant lastUpdate;
    private final Set<PaymentResponseDto> payments;
    private final Set<RentalDto> rentals;
}