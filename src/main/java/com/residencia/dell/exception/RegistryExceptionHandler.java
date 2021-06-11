/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.residencia.dell.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Dayane
 */
@ControllerAdvice
public class RegistryExceptionHandler {
    
    @ExceptionHandler (RegistryNotFoundException.class)
    public ResponseEntity <StandardError> registroNaoEncontrado (RegistryNotFoundException e, 
            HttpServletRequest request) {
        
        String error = "Registro nao encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError erro = new StandardError (new Date (), status.value(), error, e.getLocalizedMessage() , request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}
