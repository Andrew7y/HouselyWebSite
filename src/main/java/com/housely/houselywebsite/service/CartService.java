package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.Cart;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartService {

    private final WebClient webClient;

    @Autowired
    public CartService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Cart> findAllCart(Long id) {
        return webClient.get()
            .uri("/customer/{id}/cart/",id)
            .retrieve()
            .bodyToFlux(Cart.class);
    }

    // public Mono<Cart> findCartById(Long id,Long cartId) {
    //     return webClient.get()
    //         .uri("/customer/{id}/cart/{cartId}", id,cartId)
    //         .retrieve()
    //         .bodyToMono(Cart.class);
    // }

    public Mono<Cart> createCart(Cart cart, Long id) {
        return webClient.post()
            .uri("/customer/{id}/cart", id)
            .bodyValue(cart)
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                clientResponse -> clientResponse.bodyToMono(String.class)
                    .flatMap(errorBody -> Mono.error(new RuntimeException("Error: " + errorBody)))
            )
            .bodyToMono(Cart.class);
    }

    public Mono<Void> deleteCart(Long id, Long cartId) {
        return webClient.delete()
            .uri("/customer/{id}/cart/{cartId}", id, cartId)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Cart> updateCart(Cart cart, Long id, Long cartId) {
        return webClient.put()
            .uri("/customer/{id}/cart/{cartId}", id, cartId)
            .bodyValue(cart)
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                clientResponse -> clientResponse.bodyToMono(String.class)
                    .flatMap(errorBody -> Mono.error(new RuntimeException("Error: " + errorBody)))
            )
            .bodyToMono(Cart.class);
    }
}
