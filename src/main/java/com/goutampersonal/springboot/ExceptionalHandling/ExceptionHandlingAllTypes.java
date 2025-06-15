package com.goutampersonal.springboot.ExceptionalHandling;

import com.goutampersonal.springboot.CustomException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/exception")
public class ExceptionHandlingAllTypes {

    @GetMapping(path="/nullPointerException")
    public String getNullPointerException(){
        throw new NullPointerException("Throwing null pointer exception");
    }
    @GetMapping(path="/customException")
    public String getCustomException(){
        throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,"This is a custom error");
    }
    @GetMapping(path = "/customHandler")
    public ResponseEntity<?> getCustomHandler(){
        throw new CustomException(HttpStatus.NO_CONTENT,"This is a custom response");
    }
    @GetMapping(path = "/illegalArgsException")
    public ResponseEntity<?> getIllegalArgsException(){
        throw new IllegalArgumentException("This is a Illegal args exception response");
    }
    @GetMapping(path = "/responseStatusExceptionResolverClass")
    public ResponseEntity<?> responseStatusException(){
        throw new ResponseStatusExceptionResolverClass("This is a Illegal args exception response");
    }


    /**
     * This is a controller level error handler any error in this controller will be using this
     * @param exception
     * @return
     */
    @ExceptionHandler({CustomException.class, IllegalArgumentException.class})
    public ResponseEntity<String> handleErrorResponse(Exception exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }

    //This is used to send the response and let DefaultErrorAttribute class to create the response object for the
    //response thrown here

//    @ExceptionHandler({CustomException.class, IllegalArgumentException.class})
//    public void handleErrorResponse(HttpServletResponse response,Exception exception) throws IOException {
//       response.sendError(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
//    }
}

@ResponseStatus(HttpStatus.BAD_GATEWAY)
class ResponseStatusExceptionResolverClass extends RuntimeException{

    ResponseStatusExceptionResolverClass(String message){
        super(message);
    }
}


@ResponseStatus(value = HttpStatus.BAD_GATEWAY,reason = "Testing reason for error")
class ResponseStatusExceptionResolverClassForStatusAndReason extends RuntimeException{

    HttpStatus status;
    ResponseStatusExceptionResolverClassForStatusAndReason(String message,HttpStatus status){
        super(message);
        this.status=status;
    }
}