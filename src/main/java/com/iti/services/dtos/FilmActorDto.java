package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.FilmActor} entity
 */
@AllArgsConstructor
@Getter
public class FilmActorDto implements Serializable {
    private final FilmDto film;
    @NotNull
    private final Instant lastUpdate;
}