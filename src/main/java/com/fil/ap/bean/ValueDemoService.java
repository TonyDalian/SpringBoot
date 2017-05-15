package com.fil.ap.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueDemoService {
	
    @Value("${jdbc.driverClass}")
    private String driver;
    
    @Value("#{valueDemoConfiguration.name}")
    private String name;
    
    @Value("#{valueDemoConfiguration.pwd}")
    private String pwd;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}