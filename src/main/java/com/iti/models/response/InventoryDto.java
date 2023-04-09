package com.iti.models.response;

import com.iti.persistence.entities.Inventory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Inventory} entity
 */
@AllArgsConstructor
@Getter
public class InventoryDto implements Serializable {
    private final Integer id;
    @NotNull
    private final StoreDto store;
    @NotNull
    private final Instant lastUpdate;
}