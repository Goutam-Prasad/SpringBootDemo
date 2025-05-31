package com.goutampersonal.springboot.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterDependencyInjection {
    private Order order;

    SetterDependencyInjection(){
        System.out.println("Calling Setter dependency Component");
    }

    @Autowired
    public void setOrder(Order order){
        this.order=order;
        System.out.println("Called setter dependency injection method");
    }
}
