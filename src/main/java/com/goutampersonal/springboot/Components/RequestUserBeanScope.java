package com.goutampersonal.springboot.Components;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class RequestUserBeanScope {

    RequestUserBeanScope(){
        System.out.println("Calling Request Bean scope user");
    }

    @PostConstruct
    public void printHashCode(){
        System.out.println("Request scope bean user hashCode : "+this.hashCode());
    }
}
