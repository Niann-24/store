package com.cy.store.service.ex;

public class OldPasswordErrorException extends ServiceException{

    public OldPasswordErrorException() {
        super();
    }

    public OldPasswordErrorException(String message) {
        super(message);
    }

    public OldPasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public OldPasswordErrorException(Throwable cause) {
        super(cause);
    }

    protected OldPasswordErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
