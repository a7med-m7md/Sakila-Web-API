package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;



@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class CityResponseDto implements Serializable {
    private String city;
    private CountryResponseDto country;
}