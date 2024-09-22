package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.CartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CartItemService {

    @Autowired
    private RestTemplate resttemplate;

    private final String baseUrl = "http://localhost:8085/api/";
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/cart-items";

    public CartItemService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // เพิ่มสินค้าลงในตะกร้า
    public CartItem addCartItem(Long cartId, Long productId, CartItem cartItem) {
        ResponseEntity<CartItem> response = restTemplate.exchange(
            baseUrl + "/cart/" + cartId + "/product/" + productId,
            HttpMethod.POST,
            new HttpEntity<>(cartItem),
            new ParameterizedTypeReference<CartItem>() {}
        );
        return response.getBody();
    }

    // ลบสินค้าจากตะกร้า
    public void deleteCartItem(Long cartId, Long productId) {
        restTemplate.exchange(
            baseUrl + "/cart/" + cartId + "/product/" + productId,
            HttpMethod.DELETE,
            null,
            new ParameterizedTypeReference<Void>() {}
        );
    }


}
