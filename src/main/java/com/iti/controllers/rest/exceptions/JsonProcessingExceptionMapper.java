package com.iti.controllers.rest.exceptions;

import jakarta.ws.rs.ProcessingException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JsonProcessingExceptionMapper implements ExceptionMapper<ProcessingException> {
    @Override
    public Response toResponse(ProcessingException e ) {
        e.printStackTrace();
        ExceptionMessage errorMessage = ExceptionMessage.builder()
                .statusCode(400)
                .msg("Please provide a valid JSON request body.")
                .build();
        return Response.status(Response.Status.BAD_REQUEST ).entity(errorMessage).build();
    }
}