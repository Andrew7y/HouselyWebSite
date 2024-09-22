package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.FavoriteList;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FavoriteListService {

    private final WebClient webClient;

    @Autowired
    public FavoriteListService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<FavoriteList> getAllFavoriteList(){
        return webClient.get()
        .uri("/customer/{customerId}/favorite")
        .retrieve()
        .bodyToFlux(FavoriteList.class);
    }

    public Mono<FavoriteList> createFavoriteList(Long customerId, FavoriteList favoriteList) {
        return webClient.post()
            .uri("/customer/{customerId}/favorite",customerId)
            .bodyValue(favoriteList)
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                clientResponse -> clientResponse.bodyToMono(String.class)
                    .flatMap(
                            errorBody -> Mono
                            .error(new RuntimeException("Error: "+ errorBody))
                            )
                    
            )
            .bodyToMono(FavoriteList.class);
    }

    public Mono<FavoriteList> getFavoriteListById(Long customerId, Long favoriteListId) {
        return webClient.get()
            .uri("/customer/{customerId}/favorite/{favoriteListId}", customerId,favoriteListId)
            .retrieve()
            .bodyToMono(FavoriteList.class);
    }

    public Mono<Void> deleteFavoriteList(Long customerId, Long favoritedListId) {
        return webClient.delete()
            .uri("/customer/{customerId}/favorite/delete/{favoritedListId}", customerId,favoritedListId)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<FavoriteList> updateFavoriteList(Long customerId, Long favoriteListId, FavoriteList favoriteList){
        return webClient.put()
        .uri("/customer/{customerId}/favorite/update/{favoriteListId}",customerId,favoriteListId)
        .bodyValue(favoriteList)
        .retrieve()
        .onStatus(
            httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
            clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(
                        errorBody -> Mono
                        .error(new RuntimeException("Error: "+ errorBody))
                        )
                
        )
        .bodyToMono(FavoriteList.class);
    }

}
