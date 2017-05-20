package com.fil.ap.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fil.ap.rabbitmq.pojo.User;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {

    	User user = new User("Alex", "Testing1234");
    	
    	this.rabbitTemplate.convertAndSend("userpasswordQueue", user);
    }

}