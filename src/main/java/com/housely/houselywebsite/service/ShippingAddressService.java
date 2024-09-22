package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ShippingAddressService {

    private final WebClient webClient;
    private final OrderItemService orderItemService;

    @Autowired
    public ShippingAddressService(WebClient webClient, OrderItemService orderItemService){
        this.webClient = webClient;
        this.orderItemService = orderItemService;
    }

    public 
}
