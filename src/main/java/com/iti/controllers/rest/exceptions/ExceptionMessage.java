package com.iti.controllers.rest.exceptions;

import lombok.Builder;
import lombok.Getter;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Builder
@Getter
public class ExceptionMessage {
    private int statusCode;
    private String msg;
}
