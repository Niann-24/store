package com.cy.store.service.ex;
//用户名不存在异常
public class UserNonentityException extends ServiceException{
    public UserNonentityException() {
        super();
    }

    public UserNonentityException(String message) {
        super(message);
    }

    public UserNonentityException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNonentityException(Throwable cause) {
        super(cause);
    }

    protected UserNonentityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
