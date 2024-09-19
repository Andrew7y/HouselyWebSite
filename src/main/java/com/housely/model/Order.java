package com.housely.model;


import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
   
    private Long orderId;
    private LocalDateTime orderDate;
    private String paymentStatus;
    private double totalAmount;
    private CreditCard creditCard;
    private Customer customer;
    private List<OrderItem> orderItems;
    private PaymentAddress paymentAddress;
    private Shipping shipping;

}
