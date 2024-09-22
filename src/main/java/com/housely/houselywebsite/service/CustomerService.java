package com.housely.houselywebsite.service;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.housely.houselywebsite.model.Customer;



@Service
public class CustomerService {
    
    private final RestTemplate restTemplate;
    private String baseUrl = "http://localhost:8085/api/authors";

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to get customer by ID
    public Customer getCustomerById(Long id) {
        ResponseEntity<Customer> response = restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Customer>() {}
        );
        return response.getBody();
    }

    // Method to create a new customer
    public Customer createCustomer(Customer customer) {
        ResponseEntity<Customer> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.POST,
                new HttpEntity<>(customer),
                new ParameterizedTypeReference<Customer>() {}
        );
        return response.getBody();
    }

    // Method to update an existing customer
    public Customer updateCustomer(Long id, Customer customer) {
        ResponseEntity<Customer> response = restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(customer),
                new ParameterizedTypeReference<Customer>() {}
        );
        return response.getBody();
    }

    // Method to delete a customer by ID
    public void deleteCustomer(Long id) {
        restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Void>() {}
        );
    }

    // Method to search customers by name or email
    public List<Customer> searchCustomers(String keyword) {
        String searchUrl = baseUrl + "/search?keyword=" + keyword;
        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                searchUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {}
        );
        return response.getBody();
    }

}
