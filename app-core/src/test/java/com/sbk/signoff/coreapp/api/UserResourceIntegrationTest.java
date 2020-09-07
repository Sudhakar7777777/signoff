package com.sbk.signoff.coreapp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbk.signoff.coreapp.CoreAppApplication;
import com.sbk.signoff.coreapp.api.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreAppApplication.class, webEnvironment = RANDOM_PORT)
public class UserResourceIntegrationTest {
	private static final Logger logger = LoggerFactory.getLogger(UserResourceIntegrationTest.class);
	private TestRestTemplate restTemplate;
	private HttpHeaders headers;

	@LocalServerPort
	private int port;

	private String baseURL;

	@BeforeEach
	public void Setup() throws MalformedURLException {
		logger.info("Setup successful.");
		restTemplate = new TestRestTemplate("user", "password");
		baseURL = new URL("http://localhost:" + port).toString() + "/users/";
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	public void userServiceCreateWithSuccess() throws IOException {
		User user1 = buildUser();
		String userJson = getJsonStrFromUser(user1);
		HttpEntity<String> request = new HttpEntity<String>(userJson, headers);

		ResponseEntity<User> response = restTemplate.postForEntity(baseURL, request, User.class);
		logger.info("Result:" + response);

		assertTrue(response.getStatusCode() == HttpStatus.OK);
		User user2 = response.getBody();
		user1.setId(user2.getId());	//id is auto generated, override it.
		assertEquals(user1, user2);
	}

	@Test
	public void userServiceReadWithSuccess() throws IOException {
		//Add a user - 2 records
		User user1 = buildUser();
		String userJson = getJsonStrFromUser(user1);
		HttpEntity<String> request = new HttpEntity<String>(userJson, headers);

		ResponseEntity<User> response = restTemplate.postForEntity(baseURL, request, User.class);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		response = restTemplate.postForEntity(baseURL, request, User.class);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		logger.info("Result:" + response);

		//Get a All users
		ResponseEntity<List> response3 = restTemplate.exchange(baseURL, HttpMethod.GET,
				new HttpEntity<Object>(headers), List.class);
		logger.info("Result3:" + response3);
		assertTrue(response3.getStatusCode() == HttpStatus.OK);
		assertTrue(response3.getBody().size() > 0);

//		//Get a user
//		ResponseEntity<User> response2 = restTemplate.exchange(baseURL + "/1", HttpMethod.GET,
//				new HttpEntity<Object>(headers), User.class);
//		logger.info("Result2:" + response2);
//		assertTrue(response2.getStatusCode() == HttpStatus.OK);
//		assertTrue(response2.getBody().getUserName().equals(user1.getUserName()));
	}

	@Test
	public void userServiceUpdateWithSuccess() throws IOException {
		//Add a user
		User user1 = buildUser();
		String userJson = getJsonStrFromUser(user1);
		HttpEntity<String> request = new HttpEntity<String>(userJson, headers);

		ResponseEntity<User> response = restTemplate.postForEntity(baseURL, request, User.class);
		logger.info("Result:" + response);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		//Get a user
		user1.setUserName("James Bond");
		ResponseEntity<User> response2 = restTemplate.exchange(baseURL + "/1", HttpMethod.PUT,
				new HttpEntity<Object>(user1, headers), User.class);
		logger.info("Result2:" + response2);
		assertTrue(response2.getStatusCode() == HttpStatus.OK);
		assertTrue(response2.getBody().getUserName().equals("James Bond"));
	}

	@Test
	public void userServiceUpdatePasswordWithSuccess() throws IOException {
		//Add a user
		User user1 = buildUser();
		String userJson = getJsonStrFromUser(user1);
		HttpEntity<String> request = new HttpEntity<String>(userJson, headers);

		ResponseEntity<User> response = restTemplate.postForEntity(baseURL, request, User.class);
		logger.info("Result:" + response);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		//Get a user
		String newPassword = "ZingZing";
		ResponseEntity<User> response2 = restTemplate.exchange(baseURL + "/1" + "/password/" + newPassword,
				HttpMethod.PUT,
				new HttpEntity<Object>(user1, headers), User.class);
		logger.info("Result2:" + response2);
		assertTrue(response2.getStatusCode() == HttpStatus.OK);
		assertTrue(response2.getBody().getPassword().equals(newPassword));
	}

	@Test
	public void userServiceDeleteWithSuccess() throws IOException {
		//Add a user
		User user1 = buildUser();
		String userJson = getJsonStrFromUser(user1);
		HttpEntity<String> request = new HttpEntity<String>(userJson, headers);

		ResponseEntity<User> response = restTemplate.postForEntity(baseURL, request, User.class);
		logger.info("Result:" + response);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		//Get a user
		ResponseEntity<Boolean> response2 = restTemplate.exchange(baseURL + "/1", HttpMethod.DELETE,
				new HttpEntity<Object>(headers), Boolean.class);
		logger.info("Result2:" + response2);
		assertTrue(response2.getStatusCode() == HttpStatus.OK);
		assertTrue(response2.getBody() == true);
	}

	private String getJsonStrFromUser(User user) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(user);
	}

	private User buildUser() {
		return new User(1L,
				"primeUser",
				"testPassword",
				"Primary",
				"User",
				"prime@user.com",
				"1-408-408-4088",
				"addr1",
				"ca",
				"USA",
				"12345",
				new Date()
				);
	}
}
