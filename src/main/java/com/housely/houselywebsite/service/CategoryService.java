package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Category;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CategoryService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/categories";

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Category getCategoryById(Long id) {
        ResponseEntity<Category> response = restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Category>() {}
        );
        return response.getBody();
    }

    public Category createCategory(Category category) {
        ResponseEntity<Category> response = restTemplate.exchange(
            baseUrl,
            HttpMethod.POST,
            new HttpEntity<>(category),
            new ParameterizedTypeReference<Category>() {}
        );
        return response.getBody();
    }

    public Category updateCategory(Long id, Category category) {
        ResponseEntity<Category> response = restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.PUT,
            new HttpEntity<>(category),
            new ParameterizedTypeReference<Category>() {}
        );
        return response.getBody();
    }

    public void deleteCategory(Long id) {
        restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.DELETE,
            null,
            new ParameterizedTypeReference<Void>() {}
        );
    }

    public List<Category> getAllCategories() {
        ResponseEntity<List<Category>> response = restTemplate.exchange(
            baseUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Category>>() {}
        );
        return response.getBody();
    }
}
