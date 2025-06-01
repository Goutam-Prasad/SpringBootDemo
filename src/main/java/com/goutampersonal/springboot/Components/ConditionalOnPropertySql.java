package com.goutampersonal.springboot.Components;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
/*
  The combination of prefix and value are looked into application.properties file
  If not present then the bean won't be created
  If present the bean will be created
  so here sqlconnection.enabled=true will be checked in application.properties
  if not present then the bean won't be created
 */
@ConditionalOnProperty(prefix="sqlConnection",havingValue = "true",matchIfMissing = false,value ="enabled")
public class ConditionalOnPropertySql {
    ConditionalOnPropertySql(){
        System.out.println("Created sql db connection");
    }
}
