package com.fil.ap.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
    	
    	for(int i = 0; i < 100; i++) {
    		
            String context = "hello " + i;
            System.out.println("Sender1 : " + context);
            this.rabbitTemplate.convertAndSend("hello", context);
            
            try {
            	Thread.sleep(50);
            } catch(Exception e) {
            	
            	e.printStackTrace();
            }
    	}

    }

}