package com.fil.ap.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello) {
    	
        System.out.println("\t--Receiver 2 : " + hello);
        
        try {
        	Thread.sleep(200);
        } catch(Exception e) {
        	
        	e.printStackTrace();
        }
    }
}
