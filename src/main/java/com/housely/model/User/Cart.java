package com.housely.model.User;
import java.util.List;

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
public class Cart {
    private Long cartId;
    private Customer customer;
    private List<CartItem> cartItems;

}

