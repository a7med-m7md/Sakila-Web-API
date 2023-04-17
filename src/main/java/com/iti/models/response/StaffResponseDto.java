package com.iti.models.response;

import com.iti.persistence.entities.Staff;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Staff} entity
 */
@AllArgsConstructor
@Getter
public class StaffResponseDto implements Serializable {
    private final Short id;
    @Size(max = 45)
    @NotNull
    private final String firstName;
    @Size(max = 45)
    @NotNull
    private final String lastName;
//    private final byte[] picture;
    @Size(max = 50)
    private final String email;
    @NotNull
    private final Boolean active;
    @Size(max = 16)
    @NotNull
    private final String username;
    @Size(max = 40)
    private final String password;
    @NotNull
    private final Instant lastUpdate;
}