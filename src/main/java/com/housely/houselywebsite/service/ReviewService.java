package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Review;

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
public class ReviewService {

    private final WebClient webClient;

    @Autowired
    public ReviewService(WebClient webClient) {
        this.webClient = webClient;
    }

    // Fetch all reviews (assuming API call)
    public Flux<Review> findAll() {
        return webClient.get()
            .uri("/reviews")
            .retrieve()
            .bodyToFlux(Review.class); // Expect multiple Review objects
    }

    // Save a new review via POST request
    public Mono<Review> save(Review review) {
        return webClient.post()
            .uri("/reviews")
            .bodyValue(review) // Send review object as body
            .retrieve()
            .bodyToMono(Review.class); // Expect one Review object in response
    }

    // Find review by ID via GET request
    public Mono<Review> findById(Long id) {
        return webClient.get()
            .uri("/reviews/{id}", id)
            .retrieve()
            .bodyToMono(Review.class) // Expect one Review object in response
            .switchIfEmpty(Mono.error(new RuntimeException("Review not found")));
    }

    // Delete review by ID via DELETE request
    public Mono<Void> deleteById(Long id) {
        return webClient.delete()
            .uri("/reviews/{id}", id)
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }



    // // สร้างรีวิวใหม่
    // public Review createReview(Review review) {
    //     ResponseEntity<Review> response = restTemplate.exchange(
    //         baseUrl, HttpMethod.POST, new HttpEntity<>(review),
    //         new ParameterizedTypeReference<Review>() {});
    //     return response.getBody();
    // }

    // // ดึงรีวิวตาม ID
    // public Review getReviewById(Long id) {
    //     ResponseEntity<Review> response = restTemplate.exchange(
    //         baseUrl + "/" + id, HttpMethod.GET, null,
    //         new ParameterizedTypeReference<Review>() {});
    //     return response.getBody();
    // }

    // // ฟังก์ชันดึงรีวิวทั้งหมดของสินค้าตาม productId
    // public List<Review> getReviewsByProductId(Long productId) {
    //     ResponseEntity<List<Review>> response = restTemplate.exchange(
    //         baseUrl + "/product/" + productId,
    //         HttpMethod.GET,
    //         null,
    //         new ParameterizedTypeReference<List<Review>>() {}
    //     );
    //     return response.getBody();
    // }

    // // ลบรีวิวตาม ID
    // public void deleteReview(Long id) {
    //     restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, null, 
    //         new ParameterizedTypeReference<Void>() {});
    // }
}

