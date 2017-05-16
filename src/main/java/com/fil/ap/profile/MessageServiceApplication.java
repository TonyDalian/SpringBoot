package com.fil.ap.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceApplication implements CommandLineRunner {

	@Autowired
	private MessageService messageService;

	@Override
	public void run(String... args) {

		System.out.println(this.messageService.getMessage());
	}
}