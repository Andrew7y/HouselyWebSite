package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Shipping;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ShippingService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/shippings";

    public ShippingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Shipping createShipping(Shipping shipping) {
        ResponseEntity<Shipping> response = restTemplate.exchange(
            baseUrl,
            HttpMethod.POST,
            new HttpEntity<>(shipping),
            new ParameterizedTypeReference<Shipping>() {}
        );
        return response.getBody();
    }

    public Shipping getShippingById(Long id) {
        ResponseEntity<Shipping> response = restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Shipping>() {}
        );
        return response.getBody();
    }

    public Shipping updateShipping(Long id, Shipping shipping) {
        ResponseEntity<Shipping> response = restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.PUT,
            new HttpEntity<>(shipping),
            new ParameterizedTypeReference<Shipping>() {}
        );
        return response.getBody();
    }

    public void deleteShipping(Long id) {
        restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.DELETE,
            null,
            new ParameterizedTypeReference<Void>() {}
        );
    }

    public List<Shipping> trackShipping(Long orderId) {
        ResponseEntity<List<Shipping>> response = restTemplate.exchange(
            baseUrl + "/track/" + orderId,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Shipping>>() {}
        );
        return response.getBody();
    }
}
