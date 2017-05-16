package com.fil.ap.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({ "sit" })
public class MessageServiceSIT implements MessageService {

	@Value("${name:WorldSIT}")
	private String name;

	@Value("${greeting.greeting:Greeting}")
	private String greeting;
	
	public String getMessage() {
		return greeting + this.name;
	}
}
