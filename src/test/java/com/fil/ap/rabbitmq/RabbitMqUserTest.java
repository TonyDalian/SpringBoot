package com.fil.ap.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqUserTest {

	@Autowired
    private UserSender userSender;
	
	@Test
    public void user() throws Exception {
		
		userSender.send();
	}
}
