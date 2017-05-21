package com.fil.ap.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

	@RabbitHandler
    public void process(String hello) {
    	
        System.out.println("\t--Fanout Receiver B : " + hello);
	}
}