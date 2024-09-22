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

    public Mono<Category> findCategoryById(Long categoryId) {
        return webClient.get()
            .uri("/category/{categoryId}", categoryId)
            .retrieve()
            .bodyToMono(Category.class);
    }

    public Mono<Category> addCategory(Category category) {
        return webClient.post()
            .uri("/category/add")
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

    public Mono<Category> updateCategory(Category category,Long categoryId) {
        return webClient.put()
            .uri("/update/{categoryId}", categoryId)
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

    public Mono<Void> deleteCategory(Long categoryId) {
        return webClient.delete()
            .uri("/delete/{categoryId}", categoryId)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Flux<Category> findAllCategories() {
        return webClient.get()
            .uri("/category")
            .retrieve()
            .bodyToFlux(Category.class);
    }

    public Flux<Category> search(String categoryName) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder.path("/category/search")
                .queryParam("name", categoryName)
                .build())
            .retrieve()
            .bodyToFlux(Category.class);
    }
}
