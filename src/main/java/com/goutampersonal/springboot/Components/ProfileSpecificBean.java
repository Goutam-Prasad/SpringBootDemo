package com.goutampersonal.springboot.Components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("stage")//this components bean will only be created when the environment is set to stage
public class ProfileSpecificBean {
    @Value("${userName}")
    private String userName;

    @Value("${password}")
    private String password;

    ProfileSpecificBean(){
        System.out.println("Calling Profile specific bean for stage environment");
    }

    @PostConstruct
    public void init(){
        System.out.println("UserName is : "+userName+" "+"password is : "+password);
    }
}
