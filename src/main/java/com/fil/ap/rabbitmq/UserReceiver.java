package com.fil.ap.rabbitmq;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fil.ap.rabbitmq.pojo.User;

//@Component
//@RabbitListener(queues = "userpasswordQueue")
public class UserReceiver {

	private final AtomicInteger counter = new AtomicInteger();
	
    @RabbitHandler
    public void process(User user) {
    	
    	int count = counter.incrementAndGet();
    	
    	if(count == 2) {
    		
    		System.out.println("\t--userpasswordQueue Receiver : " + user.getName() + ", " + user.getPassword());
    	} else {
    		
//    		throw new RuntimeException("Failed to handle in receiver count " + count);
    	}
        
    }
}
