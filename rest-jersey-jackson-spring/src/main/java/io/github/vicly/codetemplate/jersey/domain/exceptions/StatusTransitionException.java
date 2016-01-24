package io.github.vicly.codetemplate.jersey.domain.exceptions;

import io.github.vicly.codetemplate.jersey.domain.TodoStatus;

import static jersey.repackaged.com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Vic Liu
 */
public class StatusTransitionException extends BusinessException {
    public StatusTransitionException() {
        super();
    }

    public StatusTransitionException(TodoStatus from, TodoStatus to) {
        super(String.format("Illegal status transition from %s to %s",
                checkNotNull(from),
                checkNotNull(to)));
    }

}
