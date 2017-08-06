package com.fil.ap.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
    	
    	for(int i = 0; i < 100; i++) {
    		
            String context = "world " + i;
            System.out.println("Sender2 : " + context);
            this.rabbitTemplate.convertAndSend("hello", context);

            try {
            	Thread.sleep(20);
            } catch(Exception e) {
            	
            	e.printStackTrace();
            }
    	}

    }
}
