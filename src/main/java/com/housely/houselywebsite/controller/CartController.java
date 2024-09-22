package com.housely.houselywebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.housely.houselywebsite.model.Customer;
import com.housely.houselywebsite.service.CartItemService;
import com.housely.houselywebsite.service.CartService;
import com.housely.houselywebsite.service.CustomerService;


@Controller
@RequestMapping("/web/Cart")
public class CartController {
    @Autowired
    private CartService cartService;
    private CartItemService cartItemService;
    private CustomerService customerService;
    
    @Autowired
    public CartController(CartService cartService, CartItemService cartItemService){
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/{id}")
    public String findAllCart(@PathVariable Long id,Model model) {
        Customer cust = customerService.getCustomerById(id).block();

        return "Cart";
    }
    
}
