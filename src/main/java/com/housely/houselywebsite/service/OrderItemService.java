package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Order;
import com.housely.houselywebsite.model.OrderItem;
import com.housely.houselywebsite.model.OrderItemKey;

import reactor.core.publisher.Flux;
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
public class OrderItemService {

    private final WebClient webClient;

    @Autowired
    public OrderItemService(WebClient webClient) {
        this.webClient = webClient;
    }

    
    public Flux<OrderItem> findAllCustomerOrders() {
        return webClient.get()
            .uri("/customer-orders/all")
            .retrieve()
            .bodyToFlux(OrderItem.class); 
    }

    // Save a new order item via POST request
    public Mono<OrderItem> save(OrderItem orderItem, Long cusId) {
        return webClient.post()
            .uri("/customer/{cusId}/customer-orders", cusId)
            .bodyValue(orderItem) 
            .retrieve()
            .bodyToMono(OrderItem.class); // Expect one OrderItem object in response
    }
    

    // Find order item by ID via GET request
    public Mono<OrderItem> findById(OrderItemKey id) {
        return webClient.get()
            .uri("/customer-orders/{orderId}", id) // Adjust URI according to your API
            .retrieve()
            .bodyToMono(OrderItem.class) // Expect one OrderItem object in response
            .switchIfEmpty(Mono.error(new RuntimeException("OrderItem not found")));
    }

    // Find order item by customer and order via GET request
    public Mono<OrderItem> findByCustomerAndOrder(Long cusId, Long orderId, OrderItemKey itemId) {
        return webClient.get()
            .uri("/customer/{cusId}/customer-orders/{orderId}/order-items/{itemId}", cusId, orderId, itemId)
            .retrieve()
            .bodyToMono(OrderItem.class)
            .switchIfEmpty(Mono.error(new RuntimeException("OrderItem not found")));
    }

    // Find order items by customer and order via GET request
    public Flux<OrderItem> findByOrderItem(Long cusId, Long orderId) {
        return webClient.get()
            .uri("/customer/{cusId}/customer-orders/{orderId}/order-items", cusId, orderId)
            .retrieve()
            .bodyToFlux(OrderItem.class); // Expect multiple OrderItem objects
    }

    // Find order items by order ID via GET request
    public Flux<OrderItem> findByOrderId(Long orderId) {
        return webClient.get()
            .uri("/customer-orders/{orderId}", orderId)
            .retrieve()
            .bodyToFlux(OrderItem.class); // Expect multiple OrderItem objects
    }

    // Delete order item by ID via DELETE request
    public Mono<Void> deleteById(OrderItemKey id) {
        return webClient.delete()
            .uri("/order-items/{id}", id) // Adjust URI according to your API
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }

   
}
