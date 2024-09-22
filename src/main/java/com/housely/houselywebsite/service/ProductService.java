package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Category;
import com.housely.houselywebsite.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;



public class ProductService {

    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

        // Fetch all products (assuming API call)
    public Flux<Product> findAll() {
        return webClient.get()
            .uri("/products")
            .retrieve()
            .bodyToFlux(Product.class); // Expect multiple Product objects
    }

    // Save a new product via POST request
    public Mono<Product> save(Product product, String proId) {
        if (proId == null) {
            return webClient.post()
                .uri("/products/add")
                .bodyValue(product) // Send product object as body
                .retrieve()
                .bodyToMono(Product.class); // Expect one Product object in response
        } else {
            return webClient.put()
                .uri("/products/update/{productId}", proId)
                .bodyValue(product) 
                .retrieve()
                .bodyToMono(Product.class); // สำหรับการอัปเดต
        }

    }

    // Find product by ID via GET request
    public Mono<Product> findById(String id) {
        return webClient.get()
            .uri("/products/{id}", id)
            .retrieve()
            .bodyToMono(Product.class) // Expect one Product object in response
            .switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
    }

    public Mono<Void> deleteById(String id) {
        return webClient.delete()
            .uri("/products/delete/{productId}", id)
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }


    public Mono<Product> findById(Product product,String id) {
        return webClient.put()
            .uri("/products/update/{productId}", id)
            .bodyValue(product) 
            .retrieve()
            .bodyToMono(Product.class); // สำหรับการอัปเดต
    }

    public Flux<Category> findCategoriesByProductCode(String productId) {
        return webClient.delete()
            .uri("/products/delete/{productId}", productId) // Adjust the URI to your API endpoint
            .retrieve()
            .bodyToFlux(Category.class); // Expect multiple Category objects in response
    }

    // ใน ProductService
    public Flux<Product> findByCategoryName(String categoryName) {
        return webClient.get()
            .uri("/categories/{categoryName}/products", categoryName)
            .retrieve()
            .bodyToFlux(Product.class) // Expect multiple Product objects in response
            .switchIfEmpty(Flux.error(new RuntimeException("Products not found for category: " + categoryName)));
    }


}
