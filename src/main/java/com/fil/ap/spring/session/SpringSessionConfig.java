package com.fil.ap.spring.session;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@EnableRedisHttpSession
public class SpringSessionConfig {

    @Bean
    public LettuceConnectionFactory connectionFactory() {
    	
            return new LettuceConnectionFactory(); 
    }
}
