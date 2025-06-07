package com.goutampersonal.springboot.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/requestInterceptor")
public class InterceptorController {

    @GetMapping(value="/get")
    public ResponseEntity<String> getApi(){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body("This request is made for request interceptor");
    }
}
