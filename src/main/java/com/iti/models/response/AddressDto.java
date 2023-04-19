package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;


@AllArgsConstructor
@Getter
@XmlRootElement
public class AddressDto implements Serializable {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private CityResponseDto city;
    private String postalCode;
    private String phone;
    private Instant lastUpdate;
}