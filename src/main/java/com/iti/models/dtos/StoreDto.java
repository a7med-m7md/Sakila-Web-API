package com.iti.models.dtos;

import com.iti.models.response.AddressDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Store} entity
 */
@AllArgsConstructor
@Getter
public class StoreDto implements Serializable {
    private final Short id;
    @NotNull
    private final AddressDto address;
    @NotNull
    private final Instant lastUpdate;
}