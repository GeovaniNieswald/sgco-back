package com.dgw.sgco.services.exceptions;

/**
 * DataIntegrityException
 */
public class DataIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Caso tenha algum problema de integridade (como por exemplo excluir um registro que tenha
     * associações com cascade restrict)
     * 
     * @param msg - String
     */
    public DataIntegrityException(String msg) {
        super(msg);
    }

    /**
     * Caso tenha algum problema de integridade (como por exemplo excluir um registro que tenha
     * associações com cascade restrict)
     * 
     * @param msg   - String
     * @param cause - Throwable
     */
    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
