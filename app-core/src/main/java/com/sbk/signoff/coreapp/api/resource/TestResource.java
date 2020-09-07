package com.sbk.signoff.coreapp.api.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestResource.class);

	@GetMapping("/test")
	List<String> readUsers() {
		LOGGER.info("Inside Test Resource");
		List<String> tests = Arrays.asList("One", "Two", "Three", "Four", "Five");
		LOGGER.error("No error... just testing.");
		LOGGER.info("Returning:" + tests);
		return tests;
	}

}
