package com.fil.ap.restful.feign;

import org.junit.Test;

import com.fil.ap.restful.pojo.Greeting;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class GreetFeignClient {

	@Test
	public void testFiegnGreeting() {
		try{
		String url = "http://localhost:8080";
		
		GreetingFeign greetingResource = Feign.builder()
				.encoder(new JacksonEncoder())
		        .decoder(new JacksonDecoder())
		        .target(GreetingFeign.class, url);
		
		Greeting greeting = greetingResource.getGreeting();
		
		System.out.println(greeting.getId() + " | " + greeting.getContent());
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFiegnGreetingProps() {
		try{
		String url = "http://localhost:8080";
		
		GreetingFeign greetingResource = Feign.builder()
				.encoder(new JacksonEncoder())
		        .decoder(new JacksonDecoder())
		        .target(GreetingFeign.class, url);
		
		Greeting greeting = greetingResource.getGreetingProperty("Terry");
		
		System.out.println(greeting.getId() + " | " + greeting.getContent());
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
