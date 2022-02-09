package br.com.roberto.hrsecurityapi.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/security")
public class SecurityResource {
	
	private final static Logger logger = LoggerFactory.getLogger(SecurityResource.class);
	
	//Udemy OAuth 2.0 in Spring Boot Applications
	//https://medium.com/@bcarunmail/securing-rest-api-using-keycloak-and-spring-oauth2-6ddf3a1efcc2
	@GetMapping
	private ResponseEntity<Void> security() {
		logger.info("Chamei o get do Security");
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{value}")
	private ResponseEntity<Void> security(@PathVariable String value) {
		logger.info("Chamei o get do Security" + value);
		return ResponseEntity.ok().build();
	}

}
