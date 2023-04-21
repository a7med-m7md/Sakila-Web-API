package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class AddressResponseDto implements Serializable {
    private String address;
    private  String address2;
    private  String district;
    private  String postalCode;
    private  CityResponseDto city;
    private  String phone;


    @AllArgsConstructor
    @Getter
    @Setter
    @XmlRootElement
    @NoArgsConstructor
    public static class PaymentResponseDto implements Serializable {
        private  BigDecimal amount;
        private  Instant paymentDate;
    }
}