package com.iti.models.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
public class InventoryDto implements Serializable {
    private Integer id;
    @NotNull
    private StoreResponseDto store;
    @NotNull
    private Instant lastUpdate;
}