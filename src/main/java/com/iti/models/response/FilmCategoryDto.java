package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.FilmCategory} entity
 */
@AllArgsConstructor
@Getter
@XmlRootElement
public class FilmCategoryDto implements Serializable {
    private final CategoryDto category;
    @NotNull
    private final Instant lastUpdate;
}