package com.fil.ap.restful.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties("greeting") tells Boot to take configuration properties starting with hello. 
 * and try to inject them into corresponding Bean properties of the GreetingProperties Bean.
 * 
 * @Component annotation marks this class so that Spring Boot will pick up on it scanning the classpath 
 * and turn it into a Bean. 
 *
 * Thus, if a configuration file (or another property source) contains a property greeting.greeting 
 * then the value of that property will be injected into setGreeting of our HelloProperties Bean.
 */
@Component
@ConfigurationProperties("greeting")
public class GreetingProperties {

	/**
	 * Greeting message returned by the Hello Rest service.
	 */
	private String greeting = "Welcome ";

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
