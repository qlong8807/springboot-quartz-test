package com.xa.jans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xa.jans.task.TaskManager;

@SpringBootApplication
public class Application_Quartz {
	
	@Autowired
	private TaskManager taskManager;

	public static void main(String[] args) {
		SpringApplication.run(Application_Quartz.class, args);
		
	}
}
