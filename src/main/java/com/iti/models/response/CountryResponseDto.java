package com.iti.models.response;

import com.iti.persistence.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A DTO for the {@link Country} entity
 */
@Data
@XmlRootElement
public class CountryResponseDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String country;
}