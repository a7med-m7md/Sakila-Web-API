package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Actor} entity
 */
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class ActorResponseDto implements Serializable {
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    private Instant lastUpdate;
}