package com.iti.models.response;

import com.iti.persistence.entities.Inventory;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Inventory} entity
 */
@AllArgsConstructor
@Getter
@XmlRootElement
public class InventoryDto implements Serializable {
    private final Integer id;
    @NotNull
    private final StoreResponseDto store;
    @NotNull
    private final Instant lastUpdate;
}