package com.housely.houselywebsite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@Configuration
public class AdminConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
