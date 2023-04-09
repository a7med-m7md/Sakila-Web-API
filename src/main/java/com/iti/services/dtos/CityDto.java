package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.City} entity
 */
@AllArgsConstructor
@Getter
public class CityDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String city;
    @NotNull
    private final Instant lastUpdate;
}