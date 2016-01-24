package io.github.vicly.codetemplate.jersey.api.model;

import io.github.vicly.codetemplate.jersey.domain.TodoStatus;

import static jersey.repackaged.com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Vic Liu
 */
public class TodoStatusChange {
    private TodoStatus status;

    private TodoStatusChange() {
        // for Jackson
    }

    public TodoStatusChange(TodoStatus status) {
        this.status = checkNotNull(status);
    }

    public TodoStatus getStatus() {
        return status;
    }

}
