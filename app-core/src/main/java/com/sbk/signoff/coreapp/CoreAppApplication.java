package com.sbk.signoff.coreapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreAppApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CoreAppApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Core application beginning to start...");
		SpringApplication.run(CoreAppApplication.class, args);
		LOGGER.info("Core application started and ready...");
	}

}
