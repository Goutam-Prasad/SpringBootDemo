package com.goutampersonal.springboot.Interceptor;

import com.goutampersonal.springboot.CustomAnnotations.CustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class CustomInterceptor {
    @Around("@annotation(com.goutampersonal.springboot.CustomAnnotations.CustomAnnotation)")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Do something in this method");
        Method method=((MethodSignature)joinPoint.getSignature()).getMethod();
        if(method.isAnnotationPresent(CustomAnnotation.class)){
            CustomAnnotation annotation=method.getAnnotation(CustomAnnotation.class);
            System.out.println("Annotation "+annotation.stringJKey());
        }
        joinPoint.proceed();
        System.out.println("Doing something in interceptor");
    }
}
