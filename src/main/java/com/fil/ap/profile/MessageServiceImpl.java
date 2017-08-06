package com.fil.ap.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
	
	@Value("${name}")
	private String name;

	@Value("${greeting.greeting}")
	private String greeting;
	
	public String getMessage() {
		return greeting + this.name;
	}
}
