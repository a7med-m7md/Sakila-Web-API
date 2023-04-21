package com.iti.models.request;

import com.mysql.cj.jdbc.Blob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.persistence.entities.Address} entity
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement
public class AddressRequestDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private String address;
    @Size(max = 50)
    private String address2;
    @Size(max = 20)
    @NotNull
    private String district;
    private Integer cityId;
    @Size(max = 10)
    private String postalCode;
    @Size(max = 20)
    @NotNull
    private String phone;

//    private Blob location;
}