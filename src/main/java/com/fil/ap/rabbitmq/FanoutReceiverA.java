package com.fil.ap.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

	@RabbitHandler
    public void process(String hello) {
    	
        System.out.println("\t--Fanout Receiver A : " + hello);
	}
}
