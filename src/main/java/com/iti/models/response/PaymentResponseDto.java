package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class PaymentResponseDto implements Serializable {
    private Integer id;
    private Integer customerId;
    private Short staffId;
    private Integer rentalId;
    private BigDecimal amount;
    private Instant paymentDate;
    private Instant lastUpdate;
}