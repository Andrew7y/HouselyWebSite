package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Order;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/orders";

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order getOrderById(Long id) {
        ResponseEntity<Order> response = restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Order>() {}
        );
        return response.getBody();
    }

    public Order createOrder(Order order) {
        ResponseEntity<Order> response = restTemplate.exchange(
            baseUrl,
            HttpMethod.POST,
            new HttpEntity<>(order),
            new ParameterizedTypeReference<Order>() {}
        );
        return response.getBody();
    }

    public Order updateOrder(Long id, Order order) {
        ResponseEntity<Order> response = restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.PUT,
            new HttpEntity<>(order),
            new ParameterizedTypeReference<Order>() {}
        );
        return response.getBody();
    }

    public void deleteOrder(Long id) {
        restTemplate.exchange(
            baseUrl + "/" + id,
            HttpMethod.DELETE,
            null,
            new ParameterizedTypeReference<Void>() {}
        );
    }

    public List<Order> getAllOrders() {
        ResponseEntity<List<Order>> response = restTemplate.exchange(
            baseUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Order>>() {}
        );
        return response.getBody();
    }
}
