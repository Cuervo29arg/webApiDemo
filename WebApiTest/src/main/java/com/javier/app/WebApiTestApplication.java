package com.javier.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebApiTestApplication {

	@Bean //Para inyectar la dependencia más tarde
	public RestTemplate restTemplate() { //RestTemplate para el Webservice
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebApiTestApplication.class, args);
	}
}
