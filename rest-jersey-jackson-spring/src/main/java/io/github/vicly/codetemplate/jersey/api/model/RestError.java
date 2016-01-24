package io.github.vicly.codetemplate.jersey.api.model;

/**
 * REST error model
 *
 * @author Vic Liu
 */
public class RestError {
    private String code;
    private String message;

    public RestError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
