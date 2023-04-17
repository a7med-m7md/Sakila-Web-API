package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.iti.persistence.entities.Address} entity
 */
@AllArgsConstructor
@Getter
@XmlRootElement
public class AddressResponseDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private final String address;
    @Size(max = 50)
    private final String address2;
    @Size(max = 20)
    @NotNull
    private final String district;
    @Size(max = 10)
    private final String postalCode;
    @NotNull
    private final CityResponseDto city;
    @Size(max = 20)
    @NotNull
    private final String phone;

    /**
     * A DTO for the {@link com.iti.persistence.entities.Payment} entity
     */
    @AllArgsConstructor
    @Getter
    public static class PaymentResponseDto implements Serializable {
        @NotNull
        private final BigDecimal amount;
        @NotNull
        private final Instant paymentDate;
    }
}