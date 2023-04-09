package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Inventory} entity
 */
@AllArgsConstructor
@Getter
public class InventoryDto implements Serializable {
    private final Integer id;
    @NotNull
    private final StoreDto store;
    @NotNull
    private final Instant lastUpdate;
    private final Set<RentalDto> rentals;
}