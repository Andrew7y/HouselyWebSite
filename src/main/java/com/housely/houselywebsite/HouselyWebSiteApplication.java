package com.housely.houselywebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class HouselyWebSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(HouselyWebSiteApplication.class, args);
        
    }

}
