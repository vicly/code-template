package io.github.vicly.codetemplate.jersey.api.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.vicly.codetemplate.jersey.domain.exceptions.NotFoundException;
import io.github.vicly.codetemplate.jersey.api.model.RestError;

/**
 * @author Vic Liu
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException exception) {
        RestError error = new RestError("missing", exception.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
}
