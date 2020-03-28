package com.aso01grupo4fase6.microserviceaso01grupo4fase6.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ServiceConfig {

	@Bean
	public static RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
