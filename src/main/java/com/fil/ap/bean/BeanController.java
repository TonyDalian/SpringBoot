package com.fil.ap.bean;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private ConditionListService conditionListService;
	
	@Autowired
	private ValueDemoService valueDemoService;
	
	@RequestMapping("/bean")
	public BeanConfig getBeanConfig() {
		
		BeanConfig config = new BeanConfig(
				counter.incrementAndGet(), 
				conditionListService.showListCmd(),
				valueDemoService.getDriver(),
				valueDemoService.getName(),
				valueDemoService.getPwd()
		);
		
		return config;
	}
	
	private static class BeanConfig {

		private final long id;  
		private final String listCmd;
		private final String jdbcDriver;
		private final String username;
		private final String password;
		
		public BeanConfig(long id, String listCmd, String jdbcDriver, String username, String password) {
			super();
			this.id = id;
			this.listCmd = listCmd;
			this.jdbcDriver = jdbcDriver;
			this.username = username;
			this.password = password;
		}

		public long getId() {
			return id;
		}

		public String getListCmd() {
			return listCmd;
		}

		public String getJdbcDriver() {
			return jdbcDriver;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

	}
}
