package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.PaymentAddress;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentAddressService {

    private final WebClient webClient;

    @Autowired
    public PaymentAddressService(WebClient webClient) {
        this.webClient = webClient;
    }

        // Fetch all payment addresses (assuming API call)
    public Flux<PaymentAddress> findAll() {
        return webClient.get()
            .uri("/payment-addresses")
            .retrieve()
            .bodyToFlux(PaymentAddress.class); // Expect multiple PaymentAddress objects
    }

    // Save a new payment address via POST request
    public Mono<PaymentAddress> save(PaymentAddress paymentAddress) {
        return webClient.post()
            .uri("/payment-addresses")
            .bodyValue(paymentAddress) // Send paymentAddress object as body
            .retrieve()
            .bodyToMono(PaymentAddress.class); // Expect one PaymentAddress object in response
    }

    // Find payment address by ID via GET request
    public Mono<PaymentAddress> findById(Long id) {
        return webClient.get()
            .uri("/payment-addresses/{id}", id)
            .retrieve()
            .bodyToMono(PaymentAddress.class) // Expect one PaymentAddress object in response
            .switchIfEmpty(Mono.error(new RuntimeException("PaymentAddress not found")));
    }

    // Delete payment address by ID via DELETE request
    public Mono<Void> deleteById(Long id) {
        return webClient.delete()
            .uri("/payment-addresses/{id}", id)
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }
}

