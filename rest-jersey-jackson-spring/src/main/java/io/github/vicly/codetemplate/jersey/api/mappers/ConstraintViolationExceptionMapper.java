package io.github.vicly.codetemplate.jersey.api.mappers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.vicly.codetemplate.jersey.api.model.RestError;

/**
 * @author Vic Liu
 */
@Provider
public class ConstraintViolationExceptionMapper
        implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        StringBuilder errorMessage = new StringBuilder();
        int seq = 1;
        for (ConstraintViolation cv : exception.getConstraintViolations()) {
            if (seq != 1) {
                errorMessage.append(" : ");
            }
            errorMessage.append(cv.getMessage());
        }
        RestError error = new RestError("invalid", errorMessage.toString());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
