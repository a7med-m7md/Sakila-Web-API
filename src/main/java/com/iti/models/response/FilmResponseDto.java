package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class FilmResponseDto implements Serializable {
    private String title;
    private String description;
    private Integer releaseYear;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Instant lastUpdate;
}