package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Product;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class ProductService {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/products";

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to get product by ID
    public Product getProductById(Long id) {
        ResponseEntity<Product> response = restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Product>() {}
        );
        return response.getBody();
    }

    // Method to create a new product
    public Product createProduct(Product product) {
        ResponseEntity<Product> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.POST,
                new HttpEntity<>(product),
                new ParameterizedTypeReference<Product>() {}
        );
        return response.getBody();
    }

    // Method to update an existing product
    public Product updateProduct(Long id, Product product) {
        ResponseEntity<Product> response = restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(product),
                new ParameterizedTypeReference<Product>() {}
        );
        return response.getBody();
    }

    // Method to delete a product by ID
    public void deleteProduct(Long id) {
        restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Void>() {}
        );
    }

    // Method to search products by name or category
    public List<Product> searchProducts(String keyword) {
        String searchUrl = baseUrl + "/search?keyword=" + keyword;
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                searchUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getBody();
    }
}
