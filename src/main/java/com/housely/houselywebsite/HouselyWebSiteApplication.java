package com.housely.houselywebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.core.SpringVersion;
=======
>>>>>>> 8865c00d2ca134bd124f47372a8ba3ea581d2ca7
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= "com.housely.houselywebsite")
public class HouselyWebSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(HouselyWebSiteApplication.class, args);
        
    }

}
