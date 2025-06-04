package com.goutampersonal.springboot.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPImplementation {

    // For @RestController methods
    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void runLogForRestController() {
        System.out.println("Started Aspect for RestController--------------------------------------->");
    }
}
