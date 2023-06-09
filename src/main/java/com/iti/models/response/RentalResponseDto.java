package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class RentalResponseDto implements Serializable {
    private Integer id;
    private Instant rentalDate;
//    @NotNull
//    private InventoryDto inventory;
    private CustomerResponseDto customer;
    private Instant returnDate;
    private Instant lastUpdate;
//    private Set<PaymentResponseDto> payments = new LinkedHashSet<>();
}