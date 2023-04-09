package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private final ActorDto actor;

    /**
     * A DTO for the {@link com.iti.persistence.entities.Actor} entity
     */
    @AllArgsConstructor
    @Getter
    public static class ActorDto implements Serializable {
        @Size(max = 45)
        @NotNull
        private final String firstName;
        @Size(max = 45)
        @NotNull
        private final String lastName;
    }
}