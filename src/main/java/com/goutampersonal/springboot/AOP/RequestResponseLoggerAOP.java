package com.goutampersonal.springboot.AOP;


import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.*;

import java.util.Arrays;

@Aspect
@Component
public class RequestResponseLoggerAOP {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggerAOP.class);

    @Before("execution(* com.goutampersonal.springboot..*Controller.*(..))")
    public void logRequest(JoinPoint joinPoint) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        logger.info("Incoming Request -> {} {}", request.getMethod(), request.getRequestURI());
        logger.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.goutampersonal.springboot..*Controller.*(..))", returning = "result")
    public void logResponse(Object result) {
        logger.info("Response: {}", result);
    }
}
