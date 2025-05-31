package com.goutampersonal.springboot.Components;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Autowired//This is called dependency injection
            // we could have also done Order order=new Order();
            //But this will make the code tightly coupled which
            //modification to the class harder which means that the SOLID principle(D) is violated
            //so to dependency inversion is maintained in java using dependency injection
    Order order;

    @PostConstruct
     public void preConstructBean(){
        System.out.println("Post Construct method run for bean User");
    }
    User(){
        //this way of declaring is called field injection
        System.out.println("Calling Eager Initialized User");
    }
    @PreDestroy
    public void preDestroyBean(){
        System.out.println("Pre Destroy method for bean called");
    }

}
