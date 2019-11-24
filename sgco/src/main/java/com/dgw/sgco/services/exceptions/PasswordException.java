package com.dgw.sgco.services.exceptions;

/**
 * PasswordException
 */
public class PasswordException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PasswordException(String msg) {
        super(msg);
    }

    public PasswordException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
