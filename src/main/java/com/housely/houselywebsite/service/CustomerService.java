package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class CustomerService {
    
  
    private final WebClient webClient;

    @Autowired
    public CustomerService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Customer> getAllCustomer(){
        return webClient.get()
        .uri("/customers")
        .retrieve()
        .bodyToFlux(Customer.class);
    }

    public Mono<Customer> getCustomerById(Long id){
        return webClient.get()
        .uri("/customers/{id}",id)
        .retrieve()
        .bodyToMono(Customer.class);
    }

    public Mono<Customer> addCustomer(Customer customer){
        return webClient.post()
        .uri("/customers")
        .bodyValue(customer)
        .retrieve()
        .onStatus(
            httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
            clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(
                        errorBody -> Mono
                        .error(new RuntimeException("Error: "+ errorBody))
                        )
                
        )
        .bodyToMono(Customer.class);
    }

    public Mono<Customer> updateCustomer(Long id,Customer customer){
        return webClient.put()
        .uri("/customers/{id}",id)
        .bodyValue(customer)
        .retrieve()
        .onStatus(
            httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
            clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(
                        errorBody -> Mono
                        .error(new RuntimeException("Error: "+ errorBody))
                        )
                
        )
        .bodyToMono(Customer.class);
    }

    public Mono<Void> deleteCustomer(Long id){
        return webClient.delete()
        .uri("/customers/{id}",id)
        .retrieve()
        .bodyToMono(Void.class);
    }

}
