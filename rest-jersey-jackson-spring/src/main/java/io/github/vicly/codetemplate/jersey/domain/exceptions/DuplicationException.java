package io.github.vicly.codetemplate.jersey.domain.exceptions;

/**
 * @author Vic Liu
 */
public class DuplicationException extends BusinessException {
    public DuplicationException() {
        super();
    }

    public DuplicationException(String message) {
        super(message);
    }

    public DuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationException(Throwable cause) {
        super(cause);
    }

    protected DuplicationException(String message,
                                   Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
