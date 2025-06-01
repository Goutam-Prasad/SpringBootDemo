package com.goutampersonal.springboot.BeanScopeExamples;

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
@RequestMapping(value = "/bean")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//We can also ignore this annotation as by default bean is singleton
public class SingletonBean {
    @Autowired
    User user;

    public SingletonBean(){
        System.out.println("Singleton Bean Scope created");
    }

    @PostConstruct
    public void init(){
        System.out.println("Singleton Bean scope user hashcode :"+user.hashCode());
    }

    @GetMapping(path="/test")
    public ResponseEntity<String> testApi(){
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("HI Calling test API");
    }
}
