package com.housely.houselywebsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class AdminController {
    
    @GetMapping("/")
    public String getLoginPage() {
        return "User/Home";
    }
    @GetMapping("/admin/products")
    public String getProductPage() {
        return "Admin/product";
    }
    @GetMapping("/admin/categories")
    public String getCategorPage() {
        return "Admin/categories";
    }
    @GetMapping("/admin/orders")
    public String getOrderPage() {
        return "Admin/order";
    }
    @GetMapping("/admin/customers")
    public String getCustomerPage() {
        return "Admin/customer";
    }
    @GetMapping("/admin/promotions")
    public String getPromoPage() {
        return "Admin/promotion";
    }
    @GetMapping("/admin/users")
    public String getUserPage() {
        return "Admin/admin";
    }
    @GetMapping("/admin/reports")
    public String getReportPage() {
        return "Admin/report";
    }
}
