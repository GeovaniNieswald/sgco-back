package com.dgw.sgco.resources.exceptions;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.dgw.sgco.services.exceptions.AuthorizationException;
import com.dgw.sgco.services.exceptions.DataIntegrityException;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    /**
     * Handler para quando ocorrer algum erro de conversao
     * 
     * @param e       - ParseException
     * @param request - HttpServletRequest
     * @return ResponseEntity -> StandardError -> BAD_REQUEST
     */
    @ExceptionHandler(ParseException.class)
    public ResponseEntity<StandardError> parseError(ParseException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Handler para quando ocorrer algum erro na validação dos campos
     * 
     * @param e       - MethodArgumentNotValidException
     * @param request - HttpServletRequest
     * @return ResponseEntity -> ValidationError -> BAD_REQUEST
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    /**
     * Handler para quando o usuário tentar acessar algo que não possui permissão
     * 
     * @param e       - AuthorizationException
     * @param request - HttpServletRequest
     * @return ResponseEntity -> StandardError -> FORBIDDEN
     */
    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
}
