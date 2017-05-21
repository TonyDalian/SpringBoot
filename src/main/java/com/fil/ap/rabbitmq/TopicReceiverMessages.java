package com.fil.ap.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConfig.messages)
public class TopicReceiverMessages {

	@RabbitHandler
    public void process(String hello) {
    	
        System.out.println("\t--Messages Receiver : " + hello);
    }
}
