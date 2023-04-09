package com.iti.models.response;

import com.iti.persistence.entities.Store;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Store} entity
 */
@AllArgsConstructor
@Getter
public class StoreDto implements Serializable {
    private final Short id;
    @NotNull
    private final StaffDto managerStaff;
    @NotNull
    private final Instant lastUpdate;
}