package com.iti.services.dtos;

import com.iti.persistence.entities.FilmActor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Actor} entity
 */
@AllArgsConstructor
@Getter
public class ActorDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
    @NotNull
    private final Instant lastUpdate;
    private final Set<FilmActorDto> filmActors;
}