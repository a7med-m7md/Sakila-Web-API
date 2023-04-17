package com.iti.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.persistence.entities.Customer} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class CustomerRequestDto implements Serializable {
    @NotNull
    private Short storeId;

    @NotNull
    private Integer addressId;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @Size(max = 50)
    @NotNull
    private String email;
    @NotNull
    private Boolean active;
}