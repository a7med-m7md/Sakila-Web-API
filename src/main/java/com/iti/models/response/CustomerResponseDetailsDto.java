package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Customer} entity
 */
@AllArgsConstructor
@Getter
@XmlRootElement
public class CustomerResponseDetailsDto implements Serializable {
    @NotNull
    private final StoreResponseDto store;
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
    private final Set<AddressResponseDto.PaymentResponseDto> payments;
    private final Set<RentalResponseDto> rentals;
}