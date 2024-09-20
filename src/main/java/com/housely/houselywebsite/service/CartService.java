package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Cart;
import com.housely.houselywebsite.model.CartItem;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;





@Service
public class CartService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/carts";

    public CartService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Cart createCart(Cart cart) {
        ResponseEntity<Cart> response = restTemplate.exchange(
            baseUrl, HttpMethod.POST, new HttpEntity<>(cart),
            new ParameterizedTypeReference<Cart>() {});
        return response.getBody();
    }

    public Cart getCartById(Long id) {
        ResponseEntity<Cart> response = restTemplate.exchange(
            baseUrl + "/" + id, HttpMethod.GET, null,
            new ParameterizedTypeReference<Cart>() {});
        return response.getBody();
    }

    public void deleteCart(Long id) {
        restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, null, 
            new ParameterizedTypeReference<Void>() {});
    }

    // ดึงรายการสินค้าที่อยู่ในตะกร้าโดยใช้ cartId
    public List<CartItem> getCartItemsByCartId(Long cartId) {
        ResponseEntity<List<CartItem>> response = restTemplate.exchange(
            baseUrl + "/cart/" + cartId,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<CartItem>>() {}
        );
        return response.getBody();
    }
}
