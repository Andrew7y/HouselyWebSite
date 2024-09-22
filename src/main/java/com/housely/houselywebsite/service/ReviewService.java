package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Review;
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

