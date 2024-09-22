package com.housely.houselywebsite.service;

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
    public Mono<Product> save(Product product) {
        return webClient.post()
            .uri("/products")
            .bodyValue(product) // Send product object as body
            .retrieve()
            .bodyToMono(Product.class); // Expect one Product object in response
    }

    // Find product by ID via GET request
    public Mono<Product> findById(String id) {
        return webClient.get()
            .uri("/products/{id}", id)
            .retrieve()
            .bodyToMono(Product.class) // Expect one Product object in response
            .switchIfEmpty(Mono.error(new RuntimeException("Product not found")));
    }

    // Delete product by ID via DELETE request
    public Mono<Void> deleteById(String id) {
        return webClient.delete()
            .uri("/products/{id}", id)
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }


    // public ProductService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

    // // Method to get product by ID
    // public Product getProductById(Long id) {
    //     ResponseEntity<Product> response = restTemplate.exchange(
    //             baseUrl + "/" + id,
    //             HttpMethod.GET,
    //             null,
    //             new ParameterizedTypeReference<Product>() {}
    //     );
    //     return response.getBody();
    // }

    // // Method to create a new product
    // public Product createProduct(Product product) {
    //     ResponseEntity<Product> response = restTemplate.exchange(
    //             baseUrl,
    //             HttpMethod.POST,
    //             new HttpEntity<>(product),
    //             new ParameterizedTypeReference<Product>() {}
    //     );
    //     return response.getBody();
    // }

    // // Method to update an existing product
    // public Product updateProduct(Long id, Product product) {
    //     ResponseEntity<Product> response = restTemplate.exchange(
    //             baseUrl + "/" + id,
    //             HttpMethod.PUT,
    //             new HttpEntity<>(product),
    //             new ParameterizedTypeReference<Product>() {}
    //     );
    //     return response.getBody();
    // }

    // // Method to delete a product by ID
    // public void deleteProduct(Long id) {
    //     restTemplate.exchange(
    //             baseUrl + "/" + id,
    //             HttpMethod.DELETE,
    //             null,
    //             new ParameterizedTypeReference<Void>() {}
    //     );
    // }

    // // Method to search products by name or category
    // public List<Product> searchProducts(String keyword) {
    //     String searchUrl = baseUrl + "/search?keyword=" + keyword;
    //     ResponseEntity<List<Product>> response = restTemplate.exchange(
    //             searchUrl,
    //             HttpMethod.GET,
    //             null,
    //             new ParameterizedTypeReference<List<Product>>() {}
    //     );
    //     return response.getBody();
    // }
}
