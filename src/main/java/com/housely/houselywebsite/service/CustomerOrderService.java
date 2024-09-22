package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.CustomerOrder;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerOrderService {
    private final WebClient webClient;

    @Autowired
    public CustomerOrderService(WebClient webClient){
        this.webClient = webClient;
    }

    public Flux<CustomerOrder> getAllCustomerOrders(Long cusId){
        return webClient.get()
        .uri("/customer/{cusId}/customer-orders",cusId)
        .retrieve()
        .bodyToFlux(CustomerOrder.class);
    }

    public Mono<CustomerOrder> getCustomerOrderById(Long cusID,Long orderId){
        return webClient.get()
        .uri("/customer/{cusId}/customer-orders/{orderId}",cusID,orderId)
        .retrieve()
        .bodyToMono(CustomerOrder.class);
    }

    public Mono<CustomerOrder> createOrder(Long cusId, CustomerOrder customerOrder){
        return webClient.post()
        .uri("/customer/{cusId}/customer-orders",cusId)
        .bodyValue(customerOrder)
        .retrieve()
        .onStatus(
            httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
            clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(
                        errorBody -> Mono
                        .error(new RuntimeException("Error: "+ errorBody))
                        )
                
        )
        .bodyToMono(CustomerOrder.class);
    }

    public Mono<CustomerOrder> updateOrder(Long cusId, Long orderId, CustomerOrder customerOrder){
        return webClient.put()
        .uri("/customer/{cusId}/customer-orders/{orderId}",cusId,orderId)
        .bodyValue(customerOrder)
        .retrieve()
        .onStatus(
            httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
            clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(
                        errorBody -> Mono
                        .error(new RuntimeException("Error: "+ errorBody))
                        )
                
        )
        .bodyToMono(CustomerOrder.class);
    }

    public Mono<Void> deleteOrder(Long cusId, Long orderId){
        return webClient.delete()
        .uri("/customer/{cusId}/customer-orders/{orderId}",cusId,orderId)
        .retrieve()
        .bodyToMono(Void.class);
    }
}
