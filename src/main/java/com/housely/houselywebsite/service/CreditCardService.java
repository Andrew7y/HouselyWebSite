package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.CreditCard;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CreditCardService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/creditcards";

    public CreditCardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        ResponseEntity<CreditCard> response = restTemplate.exchange(
            baseUrl, HttpMethod.POST, new HttpEntity<>(creditCard),
            new ParameterizedTypeReference<CreditCard>() {});
        return response.getBody();
    }

    public CreditCard getCreditCardById(Long id) {
        ResponseEntity<CreditCard> response = restTemplate.exchange(
            baseUrl + "/" + id, HttpMethod.GET, null,
            new ParameterizedTypeReference<CreditCard>() {});
        return response.getBody();
    }

    public void deleteCreditCard(Long id) {
        restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, null, 
            new ParameterizedTypeReference<Void>() {});
    }
}

