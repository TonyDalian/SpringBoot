package com.fil.ap.restful.feign;

import com.fil.ap.restful.pojo.Greeting;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class MultiThreadsFeign {

	public static void main(String[] args) {
		
		GreetingFeign client = Feign.builder()
				.encoder(new JacksonEncoder())
		        .decoder(new JacksonDecoder())
		        .target(GreetingFeign.class, "http://localhost:8080");
		
		new Thread(new FeignThread(client, "aaa")).start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		new Thread(new FeignThread(client, "bbb")).start();
		
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		new Thread(new FeignThread(client, "ccc")).start();
		
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		new Thread(new FeignThread(client, "ddd")).start();
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		new Thread(new FeignThread(client, "eee")).start();
	}
	
	private static class FeignThread implements Runnable {
		
		private GreetingFeign client;
		private String name;
		
		public FeignThread(GreetingFeign client, String name) {
			
			this.client = client;
			this.name = name;
		}
		
		public void run() {
			
			while(true) {
				
				Greeting greeting = client.getGreetingProperty(name);
				
				if(greeting.getContent().indexOf(name) == -1) {
					
					System.out.println("Thread not safe!!");
				}
				
				try {
					Thread.sleep(6);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}

		}
	}
}
