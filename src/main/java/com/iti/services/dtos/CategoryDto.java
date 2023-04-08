package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Category} entity
 */
@AllArgsConstructor
@Getter
public class CategoryDto implements Serializable {
    private final Short id;
    @Size(max = 25)
    @NotNull
    private final String name;
    @NotNull
    private final Instant lastUpdate;
}