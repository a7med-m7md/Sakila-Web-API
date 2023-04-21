package com.iti.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.persistence.entities.City} entity
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
public class CityRequestDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private String city;
    private Integer countryId;
}