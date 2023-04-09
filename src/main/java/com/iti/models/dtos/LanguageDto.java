package com.iti.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Language} entity
 */
@AllArgsConstructor
@Getter
public class LanguageDto implements Serializable {
    private final Short id;
    @Size(max = 20)
    @NotNull
    private final String name;
    @NotNull
    private final Instant lastUpdate;
}