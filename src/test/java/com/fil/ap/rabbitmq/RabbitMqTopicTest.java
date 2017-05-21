package com.fil.ap.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTopicTest {

	@Autowired
    private TopicSender1 sender1;
	
	@Autowired
    private TopicSender2 sender2;
	
	@Test
    public void test() throws Exception {
		
		sender1.send();
		sender2.send();
	}
}
