package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.CreditCard;

import java.io.Flushable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditCardService {

    private final WebClient webClient;

    @Autowired
    public CreditCardService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<CreditCard> getAllCreditCard(){
        return webClient.get()
        .uri("/credit-card/all")
        .retrieve()
        .bodyToFlux(CreditCard.class);
    }

    public Mono<CreditCard> addCreditCard(CreditCard creditCard) {
        return webClient.post()
            .uri("/credit-card")
            .bodyValue(creditCard)
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                clientResponse -> clientResponse.bodyToMono(String.class)
                    .flatMap(
                            errorBody -> Mono
                            .error(new RuntimeException("Error: "+ errorBody))
                            )
                    
            )
            .bodyToMono(CreditCard.class);
    }

    public Mono<CreditCard> getCreditCardById(String id) {
        return webClient.get()
            .uri("/credit-card/{id}", id)
            .retrieve()
            .bodyToMono(CreditCard.class);
    }

    public Mono<Void> deleteCreditCardById(Long id) {
        return webClient.delete()
            .uri("/credit-card/{id}", id)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<CreditCard> updateCreditCard(String id,CreditCard creditCard){
        return webClient.put()
        .uri("/credit-card/{id}",id)
        .bodyValue(creditCard)
        .retrieve()
        .onStatus(
            httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
            clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(
                        errorBody -> Mono
                        .error(new RuntimeException("Error: "+ errorBody))
                        )
                
        )
        .bodyToMono(CreditCard.class);

    }
}
