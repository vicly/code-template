package io.github.vicly.codetemplate.jersey;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.github.vicly.codetemplate.jersey.api.providers.JacksonProvider;

/**
 * JAX-RS Application
 *
 * @author Vic Liu
 */
@Configuration
@ComponentScan(basePackages = "io.github.vicly.codetemplate.jersey")
public class TodoApplication extends ResourceConfig {

    public TodoApplication() {
        packages("io.github.vicly.codetemplate.jersey.api");
        // Spring
        register(RequestContextFilter.class);
        // Jackson
        register(JacksonProvider.class);
        register(JacksonFeature.class);
        // Misc
        register(LoggingFilter.class);
    }

}
