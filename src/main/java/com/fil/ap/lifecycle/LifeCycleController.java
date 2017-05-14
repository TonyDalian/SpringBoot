package com.fil.ap.lifecycle;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LifeCycleController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IService myService;

	@Autowired
	private IMode mode;

	@RequestMapping("/lifecycle")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		if (mode == myService.getMode()) {
			
			System.out.println("The Mode Bean injected in different Bean is the same object, class type is "
					+ mode.getClass().getName());
		} else {
			
			System.out.println("The Mode Bean injected in different Bean is different object.");
			
			if (mode.getClass() == myService.getMode().getClass()) {
				
				System.out.println(" but they are the same type: " + mode.getClass().getName());
			} else {
				
				System.out.println(" and they are different type : " + mode.getClass().getName() + ","
						+ myService.getMode().getClass().getName());
			}
		}
		mode.print();

		myService.getMode().print();

		mode.print();
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	private static class Greeting {  
	
		private final long id;  
		private final String content;  
		
		public Greeting(long id, String content) {  
		    this.id = id;  
		    this.content = content;  
		}  
		
		public long getId() {  
		    return id;  
		}  
		
		public String getContent() {  
		    return content;  
		}  
	}
}