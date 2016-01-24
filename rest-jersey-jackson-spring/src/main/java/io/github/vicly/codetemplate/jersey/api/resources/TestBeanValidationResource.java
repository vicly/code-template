package io.github.vicly.codetemplate.jersey.api.resources;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Test bean validation
 *
 * @author Vic Liu
 */
@Component
@Path("/tests")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TestBeanValidationResource {

    @GET
    public String testEmail(@QueryParam("email") @Email String email) {
        return email;
    }

}
