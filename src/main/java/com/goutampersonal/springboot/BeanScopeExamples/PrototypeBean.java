package com.goutampersonal.springboot.BeanScopeExamples;

import com.goutampersonal.springboot.Components.PrototypeUser;
import com.goutampersonal.springboot.Components.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    @Autowired
    PrototypeUser user;

    @Autowired
    User singletonUser;

    public PrototypeBean(){
        System.out.println("Prototype bean controller created");
    }


    @PostConstruct
    public void init(){
        System.out.println("Prototype Bean scope user hashcode :"+user.hashCode()+" "+"For scope singleton  user hashcode : "+singletonUser.hashCode());
    }

    @GetMapping(path="/test")
    public ResponseEntity<String> testApi(){
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("HI Calling test API");
    }
}
