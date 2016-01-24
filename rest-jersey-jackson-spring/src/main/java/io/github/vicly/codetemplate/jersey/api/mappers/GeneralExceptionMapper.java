package io.github.vicly.codetemplate.jersey.api.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.vicly.codetemplate.jersey.api.model.RestError;

/**
 * @author Vic Liu
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

    private static final Logger log = LoggerFactory.getLogger(GeneralExceptionMapper.class);

    @Override
    public Response toResponse(Throwable exception) {
        log.error("Internal error", exception);
        RestError error = new RestError("server_error", exception.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
}
