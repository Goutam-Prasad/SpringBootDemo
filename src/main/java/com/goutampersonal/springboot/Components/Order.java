package com.goutampersonal.springboot.Components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Order {
    Order(){
        System.out.println("Calling lazy initialized bean: Order");
    }
}
