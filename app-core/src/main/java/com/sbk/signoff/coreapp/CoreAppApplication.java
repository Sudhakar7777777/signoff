package com.sbk.signoff.coreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class CoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreAppApplication.class, args);
	}

}
