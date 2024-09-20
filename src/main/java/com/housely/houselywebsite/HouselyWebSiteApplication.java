package com.housely.houselywebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
