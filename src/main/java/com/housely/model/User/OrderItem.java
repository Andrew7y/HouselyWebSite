package com.housely.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
 
    private OrderItemKey orderItemId;
    private int quantity;
    private Order order;
    private Product product;

}

