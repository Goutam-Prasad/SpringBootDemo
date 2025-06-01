package com.goutampersonal.springboot.Components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class InvokeApplicationProperitesWithoutProfileSpecificBean {
    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;

    InvokeApplicationProperitesWithoutProfileSpecificBean(){
        System.out.println("Calling Bean for setting environment variables");
    }

    @PostConstruct
    public void init(){
        System.out.println("UserName is : "+userName+" "+"password is : "+password);
    }
}
