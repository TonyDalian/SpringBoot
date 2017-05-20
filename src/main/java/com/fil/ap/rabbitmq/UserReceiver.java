package com.fil.ap.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fil.ap.rabbitmq.pojo.User;

@Component
@RabbitListener(queues = "userpasswordQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(User user) {
    	
        System.out.println("\t--userpasswordQueue Receiver : " + user.getName() + ", " + user.getPassword());
    }
}
