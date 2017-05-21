package com.fil.ap.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender1 {

	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	public void send() {
	    String context = "hi, i am message 1";
	    System.out.println("Sender : " + context);
	    this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	}
}
