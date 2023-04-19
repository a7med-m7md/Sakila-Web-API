package com.iti.models.response;

import com.iti.persistence.entities.Store;
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
public class StoreResponseDto implements Serializable {
    private Short id;
    private StaffResponseDto managerStaff;
    private AddressDto address;
    private Instant lastUpdate;
}