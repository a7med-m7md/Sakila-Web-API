package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link com.iti.persistence.entities.Rental} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class RentalResponseDto implements Serializable {
    private Integer id;
    @NotNull
    private Instant rentalDate;
//    @NotNull
//    private InventoryDto inventory;
    @NotNull
    private CustomerResponseDto customer;
    private Instant returnDate;
    @NotNull
    private Instant lastUpdate;
//    private Set<PaymentResponseDto> payments = new LinkedHashSet<>();
}