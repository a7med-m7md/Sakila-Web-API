package com.iti.models.response;

import com.iti.persistence.entities.Staff;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class StaffResponseDto implements Serializable {
    private Short id;
    private String firstName;
    private String lastName;
    private Short storeId;
    //    private final byte[] picture;
    private String email;
    private Boolean active;
    private String username;
    private String password;
    private Instant lastUpdate;
}