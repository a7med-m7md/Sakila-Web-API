package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Customer} entity
 */
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class CustomerResponseDetailsDto implements Serializable {
    @NotNull
    private StoreResponseDto store;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @Size(max = 50)
    private String email;
    @NotNull
    private AddressDto address;
    @NotNull
    private Boolean active;
    @NotNull
    private Instant createDate;
    private Instant lastUpdate;
    private Set<AddressResponseDto.PaymentResponseDto> payments;
    private Set<RentalResponseDto> rentals;
}