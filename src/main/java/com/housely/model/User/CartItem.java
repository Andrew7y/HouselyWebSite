package com.housely.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem {
   
    private CartItemKey id;
    private Product product;
    private Cart cart;
    private Long quantity;







}
