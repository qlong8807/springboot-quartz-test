package com.xa.jans.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class StartUpListener2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.err.println("StartUpListener2");
	}

}
