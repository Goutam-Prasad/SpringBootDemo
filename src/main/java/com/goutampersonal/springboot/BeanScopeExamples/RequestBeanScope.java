package com.goutampersonal.springboot.BeanScopeExamples;

import com.goutampersonal.springboot.Components.PrototypeUser;
import com.goutampersonal.springboot.Components.RequestUserBeanScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
@RequestMapping(path = "/request")
public class RequestBeanScope {

    @Autowired
    RequestUserBeanScope requestUser;

    @Autowired
    PrototypeUser user;
    public RequestBeanScope(){
        System.out.println("Called Request bean scope controller");
    }

    @GetMapping(path = "/user")
    public ResponseEntity<String> getUserHashCode(){
        System.out.println("User hashCode : "+user.hashCode());
        System.out.println("Request bean scope  hashCode : "+requestUser.hashCode());
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
