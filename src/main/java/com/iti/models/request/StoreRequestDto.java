package com.iti.models.request;

import lombok.*;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement
public class StoreRequestDto implements Serializable {
    private Short managerStaffId;
    private Integer addressId;
}