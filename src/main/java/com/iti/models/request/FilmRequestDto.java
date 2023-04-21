package com.iti.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * A DTO for the {@link com.iti.persistence.entities.Film} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class FilmRequestDto implements Serializable {
    @Size(max = 128)
    @NotNull
    private String title;
    private String description;
    private Integer releaseYear;
    private Short languageId;
    private Short originalLanguageId;
    private Short rentalDuration;
    @NotNull
    private BigDecimal rentalRate;
    private Integer length;
    @NotNull
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private List<Integer> actorIds;
}