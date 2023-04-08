package com.iti.services.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Film} entity
 */
@AllArgsConstructor
@Getter
public class FilmDto implements Serializable {
    private final Integer id;
    @Size(max = 128)
    @NotNull
    private final String title;
    private final String description;
    private final Integer releaseYear;
    @NotNull
    private final LanguageDto language;
    private final Short rentalDuration;
    @NotNull
    private final BigDecimal rentalRate;
    private final Integer length;
    @NotNull
    private final BigDecimal replacementCost;
    private final String rating;
    private final String specialFeatures;
    @NotNull
    private final Instant lastUpdate;
    private final Set<FilmCategoryDto> filmCategories;
}