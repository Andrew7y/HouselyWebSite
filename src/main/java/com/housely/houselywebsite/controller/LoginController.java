package com.housely.houselywebsite.controller;

import com.housely.houselywebsite.model.Customer;
import com.housely.houselywebsite.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signin")
public class LoginController {
    private final CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String signin(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/User/SignIn";
    }

    @PostMapping
    public String signin(@ModelAttribute Customer customer) {
        Customer user = customerService.findByEmail(customer.getEmail()).block();
        System.out.println("Email : "+customer.getEmail());
        System.out.println("Password : "+customer.getPassword());
        return "redirect:/";
    }
}
