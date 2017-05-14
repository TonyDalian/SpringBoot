package com.fil.ap.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueDemo {
	
    @Value("${jdbc.driverClass}")
    private String driver;
    
    @PostConstruct
    public void run(){
        System.out.println(driver);
    }
}
