package com.fil.ap.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConfigHelloUser {

    @Bean
    public Queue HelloQueue() {
    	
        return new Queue("hello");
    }

    @Bean
    public Queue UserpassQueue() {
    	
        return new Queue("userpasswordQueue");
    }
}