package com.fil.ap.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private HelloSender2 helloSender2;
    
    @Test
    public void hello() throws Exception {
    	
    	new Thread(new Runnable() {

            public void run() {
            	
            	helloSender1.send();
            }
    	}).start();
    	
    	new Thread(new Runnable() {

            public void run() {
            	
            	helloSender2.send();
            }
    	}).start();
        
        
        
        try {
        	Thread.sleep(5000);
        } catch(Exception e) {
        	
        	e.printStackTrace();
        }
    }

}