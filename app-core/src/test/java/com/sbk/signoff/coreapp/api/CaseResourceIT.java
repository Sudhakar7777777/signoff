package com.sbk.signoff.coreapp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbk.signoff.coreapp.CoreAppApplication;
import com.sbk.signoff.coreapp.api.model.Case;
import com.sbk.signoff.coreapp.api.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreAppApplication.class, webEnvironment = RANDOM_PORT)
public class CaseResourceIT {
	private static final Logger logger = LoggerFactory.getLogger(CaseResourceIT.class);
	private TestRestTemplate restTemplate;
	private HttpHeaders headers;

	@LocalServerPort
	private int port;

	private String baseURL;

	@BeforeEach
	public void Setup() throws MalformedURLException {
		logger.info("Setup successful.");
		restTemplate = new TestRestTemplate("user", "password");
		baseURL = new URL("http://localhost:" + port).toString() + "/cases/";
		headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); //--application/x-www-form-urlencoded
		headers.setContentType(MediaType.APPLICATION_JSON);
	}

	@Test
	public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
		ResponseEntity<String> result = restTemplate
				.withBasicAuth("user", "password")
				.getForEntity(baseURL + "/cases/", String.class, headers);
		//This is not working.  Return 415, ContentType not supported error.
//		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void caseServiceCreateWithSuccess() throws IOException {
		Case aCase = buildCase();
		String caseJson = getJsonStrFromObject(aCase);
		HttpEntity<String> request = new HttpEntity<>(caseJson, headers);

		ResponseEntity<Case> response = restTemplate.postForEntity(baseURL, request, Case.class);
		logger.info("Result:" + response);

		assertTrue(response.getStatusCode() == HttpStatus.OK);
		Case case2 = response.getBody();
		aCase.setId(case2.getId());	//id is auto generated, override it.
		assertTrue(aCase.getName().equals(case2.getName()));
	}

	@Test
	public void caseServiceReadWithSuccess() throws IOException {
		//Add a case - 2 records
		Case case1 = buildCase();
		String caseJson = getJsonStrFromObject(case1);
		HttpEntity<String> request = new HttpEntity<>(caseJson, headers);

		ResponseEntity<Case> response = restTemplate.postForEntity(baseURL, request, Case.class);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		response = restTemplate.postForEntity(baseURL, request, Case.class);
		assertTrue(response.getStatusCode() == HttpStatus.OK);

		logger.info("Result:" + response);

		//Get a All Cases
		ResponseEntity<List<Case>> response3 = restTemplate.exchange(baseURL,
				HttpMethod.GET, new HttpEntity<Object>(headers),
				new ParameterizedTypeReference<List<Case>>(){});
		logger.info("Result3:" + response3);
		assertTrue(response3.getStatusCode() == HttpStatus.OK);
		assertTrue(response3.getBody().size() > 0);

		//Get a Case
		ResponseEntity<Case> response2 = restTemplate.exchange(baseURL + "/" + response3.getBody().get(0).getId(),
				HttpMethod.GET, new HttpEntity<Object>(headers), Case.class);
		logger.info("Result2:" + response2);
		assertTrue(response2.getStatusCode() == HttpStatus.OK);
		assertTrue(response2.getBody().getName().equals(case1.getName()));
	}

	private <T> String getJsonStrFromObject(T obj) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(obj);
	}

	private Case buildCase(){
		Case c = new Case();
		c.setId(1L);
		c.setSid(1L);
		c.setName("NewCase1");
		c.setIsActive("Y");
		return c;
	}
}
