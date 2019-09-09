package com.dgw.sgco.services.exceptions;

/**
 * ObjectNotFoundException
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param msg - String
     */
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 
     * @param msg   - String
     * @param cause - Throwable
     */
    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
