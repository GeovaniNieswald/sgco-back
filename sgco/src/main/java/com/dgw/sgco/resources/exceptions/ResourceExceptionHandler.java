package com.dgw.sgco.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import com.dgw.sgco.services.exceptions.DataIntegrityException;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ResourceExceptionHandler
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Handler para quando não encontrar o objeto
     * 
     * @param e       - ObjectNotFoundException
     * @param request - HttpServletRequest
     * @return ResponseEntity -> StandardError -> NOT_FOUND
     */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /**
     * Handler para quando ocorrer algum erro de integridade
     * 
     * @param e       - DataIntegrityException
     * @param request - HttpServletRequest
     * @return ResponseEntity -> StandardError -> BAD_REQUEST
     */
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
