package com.housely.houselywebsite.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class CustomerOrder {

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
