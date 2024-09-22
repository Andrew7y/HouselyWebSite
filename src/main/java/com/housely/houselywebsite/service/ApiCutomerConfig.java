package com.housely.houselywebsite.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiCutomerConfig {
    
  	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		
		return builder.baseUrl("http://localhost:8085/api").build();
	}

}
