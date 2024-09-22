package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.CartItem;
import com.housely.houselywebsite.model.CartItemKey;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartItemService {

    private final WebClient webClient;
    private final CartService cartService;

    @Autowired
    public CartItemService(WebClient webClient,CartService cartService) {
        this.webClient = webClient;
        this.cartService = cartService;
    }

    public Flux<CartItem> getAllCartItem(Long id,Long cartId){
        return webClient.get()
            .uri("/customer/{id}/cart/{cartId}/cart-item",id,cartId)
            .retrieve()
            .bodyToFlux(CartItem.class);
    }

    public Mono<CartItem> getCartItemById(Long id,Long cartId,CartItemKey cartItemId){
        return webClient.get()
        .uri("/customer/{id}/cart/{cartId}/cart-item/{cartItemId}",id,cartId,cartItemId)
        .retrieve()
        .bodyToMono(
            CartItem.class
        );
    }

    public Mono<CartItem> addCartItem(CartItem cartItem, Long id, Long cartId) {
        return cartService.findCartById(cartId) // ตรวจสอบว่าตะกร้ามีอยู่จริง
            .flatMap(cart -> {
                if (cart.getCustomer().getId().equals(id)) { // ตรวจสอบว่าตะกร้าเป็นของลูกค้าที่ถูกต้อง
                    cartItem.setCart(cart);
                    return webClient.post()
                        .uri("/customer/{id}/cart/{cartId}/cart-item", id, cartId)
                        .bodyValue(cartItem)
                        .retrieve()
                        .bodyToMono(CartItem.class);
                } else {
                    return Mono.error(new RuntimeException("Cart does not belong to the customer"));
                }
            });
    }
    
    public Mono<CartItem> updateCartItem(CartItem cartItem, Long id, Long cartId, CartItemKey cartItemId) {
        return cartService.findCartById(cartId) // ตรวจสอบว่าตะกร้ามีอยู่จริง
            .flatMap(cart -> {
                if (cart.getCustomer().getId().equals(id)) { 
                    cartItem.setCart(cart);
                    cartItem.setId(cartItemId);
                    return webClient.put()
                        .uri("/customer/{id}/cart/{cartId}/cart-item/{cartItemId}", id, cartId, cartItemId)
                        .bodyValue(cartItem)
                        .retrieve()
                        .bodyToMono(CartItem.class);
                } else {
                    return Mono.error(new RuntimeException("Cart does not belong to the customer"));
                }
            });
    }
    
    
    public Mono<Void> deleteCartItem(Long id, Long cartId, CartItemKey cartItemId) {
        return cartService.findCartById(cartId)
            .flatMap(cart -> {
                if (cart.getCustomer().getId().equals(id)) { 
                    return webClient.delete()
                        .uri("/customer/{id}/cart/{cartId}/cart-item/{cartItemId}", id, cartId, cartItemId)
                        .retrieve()
                        .bodyToMono(Void.class);
                } else {
                    return Mono.error(new RuntimeException("Cart does not belong to the customer"));
                }
            });
    }
    
    
}
