package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {


    @Value("${test.property}")
    private Integer testProperty;


    public String getTestProperty() {
        System.out.println("testProperty: " + this.testProperty);
        return "" + testProperty;
        
    }
}
