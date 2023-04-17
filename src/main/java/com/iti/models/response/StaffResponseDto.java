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

/**
 * A DTO for the {@link Staff} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
public class StaffResponseDto implements Serializable {
    private Short id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    private Short storeId;
    //    private final byte[] picture;
    @Size(max = 50)
    private String email;
    @NotNull
    private Boolean active;
    @Size(max = 16)
    @NotNull
    private String username;
    @Size(max = 40)
    private String password;
    @NotNull
    private Instant lastUpdate;
}