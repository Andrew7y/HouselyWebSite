package com.housely.houselywebsite.controller;

import com.housely.houselywebsite.model.Customer;
import com.housely.houselywebsite.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    private final CustomerService customerService;

    public SignUpController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String signup(Model model) {
        Customer customer = new Customer();
        String confirmPassword = "";
        model.addAttribute("customer", customer);
        model.addAttribute("confirmPassword", confirmPassword);
        return "/User/SignUp";
    }

    @PostMapping
    public String signup(@ModelAttribute Customer customer) {
        customerService.save(customer).block();
        return "redirect:/";
    }
}
