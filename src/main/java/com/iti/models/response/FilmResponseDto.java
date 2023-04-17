package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Film} entity
 */
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class FilmResponseDto implements Serializable {
    @Size(max = 128)
    @NotNull
    private String title;
    private String description;
    private Integer releaseYear;
    private Short rentalDuration;
    @NotNull
    private BigDecimal rentalRate;
    private Integer length;
    @NotNull
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    @NotNull
    private Instant lastUpdate;
}