package com.iti.models.response;

import com.iti.persistence.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Country} entity
 */
@Data
public class CountryResponseDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String country;
}