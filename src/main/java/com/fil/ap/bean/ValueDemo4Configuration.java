package com.fil.ap.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueDemo4Configuration {
	
    @Value("${jdbc.driverClass}")
    private String driver;
    
    @Value("#{valueDemoConfiguration.name}")
    private String name;
    
    //@Value("${ '#{anotherObj.media}' }") //这个不支持。
//    @Value("#{ '${media}' }")
//    private String media;
    
    @PostConstruct
    public void run(){
        System.out.println(driver);
        System.out.println(name);
//        System.out.println(media);
    }
    
}