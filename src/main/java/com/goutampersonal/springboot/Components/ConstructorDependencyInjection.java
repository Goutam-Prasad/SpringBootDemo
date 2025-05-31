package com.goutampersonal.springboot.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorDependencyInjection {
    /**
     * This is the most recommended way of dependency injection
     *
     */

    private final Order order;
    private final User user;
    @Autowired
    ConstructorDependencyInjection(Order order,User user){
        this.user=user;
        this.order=order;
        System.out.println("Called constructor injection class");
    }
}
