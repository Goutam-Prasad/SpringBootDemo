package com.goutampersonal.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> getGlobalConfigurationError(Exception exception){
        return new ResponseEntity<>(exception.getMessage()+" "+"This is global error handler", HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
