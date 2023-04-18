package com.iti.controllers.rest.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class ThrowableExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        exception.printStackTrace();
        ExceptionMessage errorMessage = ExceptionMessage
                .builder()
                .statusCode(400)
                .msg(exception.getMessage())
                .build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }

}
