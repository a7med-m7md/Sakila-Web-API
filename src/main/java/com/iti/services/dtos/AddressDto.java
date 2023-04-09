package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Address} entity
 */
@AllArgsConstructor
@Getter
public class AddressDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String address;
    @Size(max = 50)
    private final String address2;
    @Size(max = 20)
    @NotNull
    private final String district;
    @NotNull
    private final CityDto city;
    @Size(max = 10)
    private final String postalCode;
    @Size(max = 20)
    @NotNull
    private final String phone;
    @NotNull
    private final Instant lastUpdate;
    private final Set<CustomerDto> customers;
}