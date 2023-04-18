package com.iti.controllers.rest.exceptions;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        exception.printStackTrace();
        ExceptionMessage errorMessage = ExceptionMessage
                .builder()
                .statusCode(400)
                .msg("Validation failed!")
                .build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
}
