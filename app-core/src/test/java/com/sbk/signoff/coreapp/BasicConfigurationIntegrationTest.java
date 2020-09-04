package com.sbk.signoff.coreapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BasicConfigurationIntegrationTest {
//	private static final Logger logger = LoggerFactory.getLogger(BasicConfigurationIntegrationTest.class);

	@LocalServerPort
	int port;

//	Use this method if you want to create custom TestRestTemplate and use throughout the test case.
//	@TestConfiguration
//	static class TestRestTemplateAuthenticationConfiguration {
//
//		@Value("${spring.security.user.name}")
//		private String userName;
//
//		@Value("${spring.security.user.password}")
//		private String password;
//
//		@Bean
//		public RestTemplateBuilder restTemplateBuilder() {
//			return new RestTemplateBuilder().basicAuthentication(userName, password);
//		}
//	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void whenLoggedUserRequestsHomePage_ThenSuccess() throws IllegalStateException, IOException {
		restTemplate = new TestRestTemplate("user", "password");
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port).toString(), String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("COMING"));
	}

	@Test
	public void whenUserWithWrongCredentials_thenUnauthorizedPage() throws Exception {
		//restTemplate = new TestRestTemplate("user", "wrongpassword");
		ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port).toString(), String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
		assertTrue(response.getBody().contains("Unauthorized"));
	}
}
