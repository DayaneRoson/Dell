
package com.residencia.dell.exception;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Dayane
 */
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler (value = {ConstraintViolationException.class})
    public ResponseEntity<StandardError> handleConstraintViolation(ConstraintViolationException e,
             HttpServletRequest request) {
        String error = "Valor digitado inválido";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError erro = new StandardError (new Date (), status.value(), error,
                e.getLocalizedMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
   
}
