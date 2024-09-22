package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.Category;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {

    private final WebClient webClient;

    @Autowired
    public CategoryService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Category> findCategoryById(Long id) {
        return webClient.get()
            .uri("/category/{id}", id)
            .retrieve()
            .bodyToMono(Category.class);
    }

    public Mono<Category> addCategory(Category category) {
        return webClient.post()
            .uri("/category")
            .bodyValue(category)
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                clientResponse -> clientResponse.bodyToMono(String.class)
                    .flatMap(
                            errorBody -> Mono
                            .error(new RuntimeException("Error: "+ errorBody))
                            )
                    
            )
            .bodyToMono(Category.class);
    }

    public Mono<Category> updateCategory(Long id, Category category) {
        return webClient.put()
            .uri("/category/{id}", id)
            .bodyValue(category)
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError() || httpStatus.is5xxServerError(),
                clientResponse -> clientResponse.bodyToMono(String.class)
                    .flatMap(
                            errorBody -> Mono
                            .error(new RuntimeException("Error: "+ errorBody))
                            )
                    
            )
            .bodyToMono(Category.class);
    }

    public Mono<Void> deleteCategory(Long id) {
        return webClient.delete()
            .uri("/category/{id}", id)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Flux<Category> findAllCategories() {
        return webClient.get()
            .uri("/category")
            .retrieve()
            .bodyToFlux(Category.class);
    }
}
