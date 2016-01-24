package io.github.vicly.codetemplate.jersey.api.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.vicly.codetemplate.jersey.domain.exceptions.StatusTransitionException;
import io.github.vicly.codetemplate.jersey.api.model.RestError;

/**
 * @author Vic Liu
 */
@Provider
public class StatusTransitionExceptionMapper implements ExceptionMapper<StatusTransitionException> {
    @Override
    public Response toResponse(StatusTransitionException exception) {
        RestError error = new RestError("missing", exception.getMessage());
        return Response.status(Response.Status.CONFLICT).entity(error).build();
    }
}
