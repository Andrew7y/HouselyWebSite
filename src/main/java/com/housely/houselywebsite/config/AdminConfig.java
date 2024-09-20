package com.housely.houselywebsite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@Configuration
public class AdminConfig {
<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/config/AdminConfig.java
=======

>>>>>>> 8865c00d2ca134bd124f47372a8ba3ea581d2ca7:src/main/java/com/housely/houselywebsite/AdminConfig.java
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
