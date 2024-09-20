package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
    
    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/api";

    public boolean authenticate(String username, String password){
        Map<String, String> requestPayload = new HashMap<>();
        requestPayload.put("username", username);
        requestPayload.put("password", password);

        try{
            ResponseEntity<Boolean> response = restTemplate.postForEntity(baseUrl, requestPayload, Boolean.class);
        }
    }
}
