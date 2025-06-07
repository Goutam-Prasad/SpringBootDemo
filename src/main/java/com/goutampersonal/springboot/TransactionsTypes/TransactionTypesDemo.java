package com.goutampersonal.springboot.TransactionsTypes;

import com.goutampersonal.springboot.Components.TransactionalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/version")
public class TransactionTypesDemo {
    @Autowired
    TransactionalUserService userService;

    @GetMapping(value = "/get")
    public String getDetails() {
        userService.method1();
        return "Hello";
    }
}