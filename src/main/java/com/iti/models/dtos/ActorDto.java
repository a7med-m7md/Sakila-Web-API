package com.iti.models.dtos;

import com.iti.persistence.entities.Actor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Actor} entity
 */
@AllArgsConstructor
@Getter
public class ActorDto implements Serializable {
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
    @NotNull
    private final Instant lastUpdate;
}