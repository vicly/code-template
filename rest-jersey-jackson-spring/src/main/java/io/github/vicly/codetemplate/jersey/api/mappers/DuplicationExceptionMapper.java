package io.github.vicly.codetemplate.jersey.api.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.vicly.codetemplate.jersey.domain.exceptions.DuplicationException;
import io.github.vicly.codetemplate.jersey.api.model.RestError;

/**
 * @author Vic Liu
 */
@Provider
public class DuplicationExceptionMapper implements ExceptionMapper<DuplicationException> {
    @Override
    public Response toResponse(DuplicationException exception) {
        RestError error = new RestError("already_exist", exception.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
