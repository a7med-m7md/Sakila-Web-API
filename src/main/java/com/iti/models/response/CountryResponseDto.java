package com.iti.models.response;

import com.iti.persistence.entities.Country;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class CountryResponseDto implements Serializable {
    private String country;
}