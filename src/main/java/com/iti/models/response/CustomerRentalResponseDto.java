package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class CustomerRentalResponseDto implements Serializable {
    private Integer id;
    private Instant rentalDate;
    private InventoryDto inventory;
    private Instant returnDate;
    private Set<AddressResponseDto.PaymentResponseDto> payments;
    private FilmResponseDto film;

}