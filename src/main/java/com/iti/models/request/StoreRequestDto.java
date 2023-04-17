package com.iti.models.request;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.iti.persistence.entities.Store} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoreRequestDto implements Serializable {
    private Short managerStaffId;
    private Integer addressId;
}