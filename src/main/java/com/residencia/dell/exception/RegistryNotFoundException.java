
package com.residencia.dell.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Dayane
 */
public class RegistryNotFoundException extends RuntimeException {
    
   public RegistryNotFoundException (Integer id) {
       super ("Registro não encontrado Id: "+ id);
   }
    
    
}
