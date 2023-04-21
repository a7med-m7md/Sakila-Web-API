package com.iti.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.persistence.entities.Actor} entity
 */
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class ActorRequestDto implements Serializable {
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
}