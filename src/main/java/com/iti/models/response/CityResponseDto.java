package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.persistence.entities.City} entity
 */
@Data
@XmlRootElement
public class CityResponseDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String city;
    @NotNull
    private final CountryResponseDto country;
}