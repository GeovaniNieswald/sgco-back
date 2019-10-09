package com.dgw.sgco.services.exceptions;

/**
 * AuthorizationException
 */
public class AuthorizationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Caso tenha algum problema de autorização
     * 
     * @param msg - String
     */
    public AuthorizationException(String msg) {
        super(msg);
    }

    /**
     * Caso tenha algum problema de autorização
     * 
     * @param msg   - String
     * @param cause - Throwable
     */
    public AuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
