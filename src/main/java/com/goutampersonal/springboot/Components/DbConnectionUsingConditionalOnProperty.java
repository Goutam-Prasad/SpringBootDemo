package com.goutampersonal.springboot.Components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DbConnectionUsingConditionalOnProperty {
    @Autowired(required = false)
    /*
    required false tells spring boot that object should not be resolved
    if not present it might be present but if not don't resolve it
     */
    ConditionalOnPropertyNoSql nosqlConnection;

    @Autowired(required = false)
    ConditionalOnPropertySql sqlConnection;

    @PostConstruct
    public void init(){
        System.out.println("DB connection created with dependencies mentioned below");
        System.out.println("Is created using sqlConnection :"+ Objects.isNull(sqlConnection));
        System.out.println("Is created using NoSqlConnection :"+Objects.isNull(nosqlConnection));
    }
}
