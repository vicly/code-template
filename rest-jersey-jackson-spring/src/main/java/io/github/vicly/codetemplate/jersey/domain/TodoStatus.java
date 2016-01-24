package io.github.vicly.codetemplate.jersey.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Vic Liu
 */
public enum TodoStatus {
    PENDING("pending"), COMPLETE("complete");

    private String code;
    private TodoStatus(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return this.code;
    }

    @JsonCreator
    public static TodoStatus fromCode(String code) {
        for (TodoStatus status : TodoStatus.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown TodoStatus code: " + code);
    }
}
