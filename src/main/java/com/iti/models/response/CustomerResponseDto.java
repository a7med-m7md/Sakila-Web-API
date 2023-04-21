package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;


@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class CustomerResponseDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
    private Instant createDate;
    private Instant lastUpdate;
}