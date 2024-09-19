package com.housely.houselywebsite;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Bean;

@Configuration
public class AdminConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
		
		return builder.baseUrl("http://localhost:8085/api").build();
	}


}
