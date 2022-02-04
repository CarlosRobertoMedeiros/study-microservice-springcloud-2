package br.com.roberto.hrpayroll.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
	
	@Bean //Por ser Estático é um Singleton
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
