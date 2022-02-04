package br.com.roberto.hrnamingservereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrNamingServerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrNamingServerEurekaApplication.class, args);
	}

}
