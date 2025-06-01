package com.goutampersonal.springboot.Components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentInspector {

    @Autowired
    private ConfigurableEnvironment environment;
    EnvironmentInspector(){
        System.out.println("Calling environment inspector class to print all env variables");
    }

    @PostConstruct
    public void printAllProperties() {
        System.out.println("=== Active Environment Properties ===");
        for (PropertySource<?> propertySource : environment.getPropertySources()) {
            System.out.println(">> Source: " + propertySource.getName());
            if (propertySource.getSource() instanceof java.util.Map map) {
                for (Object key : map.keySet()) {
                    if (key.toString().toLowerCase().contains("user") || key.toString().toLowerCase().contains("password")) {
                        System.out.println(key + " = " + map.get(key));
                    }
                }
            }
        }
    }
}
