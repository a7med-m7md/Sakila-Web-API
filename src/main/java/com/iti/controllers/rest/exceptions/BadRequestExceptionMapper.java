package com.iti.controllers.rest.exceptions;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException exception) {
        exception.printStackTrace();
        ExceptionMessage errorMessage = ExceptionMessage.builder()
                .statusCode(400)
                .msg(exception.getMessage())
                .build();
        return Response.status(Response.Status.BAD_REQUEST ).entity(errorMessage).build();
    }
}
