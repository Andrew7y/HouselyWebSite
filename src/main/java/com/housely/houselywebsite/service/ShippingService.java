package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Shipping;

import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class ShippingService {

    private final WebClient webClient;

    @Autowired
    public ShippingService(WebClient webClient) {
        this.webClient = webClient;
    }

    // Fetch all shippings (assuming API call)
    public Mono<List<Shipping>> findAll() {
        return webClient.get()
            .uri("/shippings")
            .retrieve()
            .bodyToFlux(Shipping.class)
            .collectList();  // Convert Flux to List
    }

    // Save a new shipping via POST request
    public Mono<Shipping> save(Shipping shipping) {
        return webClient.post()
            .uri("/shippings")
            .bodyValue(shipping)
            .retrieve()
            .bodyToMono(Shipping.class);  // Response expected to return a Shipping object
    }

    // Find shipping by ID via GET request
    public Mono<Shipping> findById(Long id) {
        return webClient.get()
            .uri("/shippings/{id}", id)
            .retrieve()
            .bodyToMono(Shipping.class)
            .switchIfEmpty(Mono.error(new RuntimeException("Shipping not found")));
    }

    // Delete shipping by ID via DELETE request
    public Mono<Void> deleteById(Long id) {
        return webClient.delete()
            .uri("/shippings/{id}", id)
            .retrieve()
            .bodyToMono(Void.class);
    }

    // private final String baseUrl = "http://localhost:8085/api/shipping";

    // public ShippingService createShippingService(ShippingService ship){
    //     return rest.postForObject(baseUrl, ship, ShippingService.class);
    // }

    // public 


    // public ShippingService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

    // public Shipping createShipping(Shipping shipping) {
    //     ResponseEntity<Shipping> response = restTemplate.exchange(
    //         baseUrl,
    //         HttpMethod.POST,
    //         new HttpEntity<>(shipping),
    //         new ParameterizedTypeReference<Shipping>() {}
    //     );
    //     return response.getBody();
    // }

    // public Shipping getShippingById(Long id) {
    //     ResponseEntity<Shipping> response = restTemplate.exchange(
    //         baseUrl + "/" + id,
    //         HttpMethod.GET,
    //         null,
    //         new ParameterizedTypeReference<Shipping>() {}
    //     );
    //     return response.getBody();
    // }

    // public Shipping updateShipping(Long id, Shipping shipping) {
    //     ResponseEntity<Shipping> response = restTemplate.exchange(
    //         baseUrl + "/" + id,
    //         HttpMethod.PUT,
    //         new HttpEntity<>(shipping),
    //         new ParameterizedTypeReference<Shipping>() {}
    //     );
    //     return response.getBody();
    // }

    // public void deleteShipping(Long id) {
    //     restTemplate.exchange(
    //         baseUrl + "/" + id,
    //         HttpMethod.DELETE,
    //         null,
    //         new ParameterizedTypeReference<Void>() {}
    //     );
    // }

    // public List<Shipping> trackShipping(Long orderId) {
    //     ResponseEntity<List<Shipping>> response = restTemplate.exchange(
    //         baseUrl + "/track/" + orderId,
    //         HttpMethod.GET,
    //         null,
    //         new ParameterizedTypeReference<List<Shipping>>() {}
    //     );
    //     return response.getBody();
    // }
}
