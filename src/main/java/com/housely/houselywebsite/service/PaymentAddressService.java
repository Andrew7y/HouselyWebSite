package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.OrderItem;
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
            .uri("/payments")
            .retrieve()
            .bodyToFlux(PaymentAddress.class); // Expect multiple PaymentAddress objects
    }

    // Save a new payment address via POST request
    public Mono<PaymentAddress> save(Long id, PaymentAddress paymentAddress) {
        if (id == null) {
            return webClient.post()
            .uri("/payment/add")
            .bodyValue(paymentAddress) // Send paymentAddress object as body
            .retrieve()
            .bodyToMono(PaymentAddress.class); // Expect one PaymentAddress object in response
    
        } else {
            return webClient.put()
                .uri("/payment/edit/{id}", id)
                .bodyValue(paymentAddress) 
                .retrieve()
                .bodyToMono(PaymentAddress.class); // สำหรับการอัปเดต
        }
    }

    // Find payment address by ID via GET request
    public Mono<PaymentAddress> findById(Long id) {
        return webClient.get()
            .uri("/payment/{id}", id)
            .retrieve()
            .bodyToMono(PaymentAddress.class) // Expect one PaymentAddress object in response
            .switchIfEmpty(Mono.error(new RuntimeException("PaymentAddress not found")));
    }

    // Delete payment address by ID via DELETE request
    public Mono<Void> deleteById(Long id) {
        return webClient.delete()
            .uri("/payment/{id}", id)
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }
}

