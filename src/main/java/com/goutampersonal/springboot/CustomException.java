package com.goutampersonal.springboot;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    HttpStatus status;
    String message;
    String errorCode;

    CustomException(HttpStatus status,String message, String errorCode){
        this.errorCode=errorCode;
        this.message=message;
        this.status=status;
    }
    public CustomException(HttpStatus status, String message){
        this.errorCode="Error Code not defined";
        this.message=message;
        this.status=status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
