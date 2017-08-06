package com.fil.ap.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fil.ap.restful.config.GreetingProperties;
import com.fil.ap.restful.pojo.Greeting;

@Profile({ "uat" })
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingProperties props;
    
    @RequestMapping("/greeting")
    public Greeting greeting(
    		@RequestParam(value="name", defaultValue="World") String name
    		) {
        return new Greeting(
        		counter.incrementAndGet(),
                String.format(template, name)
        );
    }
    
    @RequestMapping("/greeting_props")
    public Greeting greetingProperties(
    		@RequestParam(value="name", defaultValue="World") String name
    		) {
        return new Greeting(
        		counter.incrementAndGet(),
        		props.getGreeting()+name
        );
    }
}