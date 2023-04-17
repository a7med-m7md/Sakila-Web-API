package com.iti.models.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Staff} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffRequestDto implements Serializable {
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    private Integer addressId;
//    private byte[] picture;
    @Size(max = 50)
    private String email;
    private Integer storeId;
    @NotNull
    private Boolean active = false;
    @Size(max = 16)
    @NotNull
    private String username;
    @Size(max = 40)
    private String password;
}