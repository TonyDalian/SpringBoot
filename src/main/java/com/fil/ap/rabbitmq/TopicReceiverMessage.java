package com.fil.ap.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//@RabbitListener(queues = RabbitConfigTopic.message)
public class TopicReceiverMessage {

	@RabbitHandler
    public void process(String hello) {
    	
        System.out.println("\t--Message Receiver : " + hello);
    }
}
