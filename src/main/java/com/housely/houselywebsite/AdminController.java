package com.housely.houselywebsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
    
    @RequestMapping("/")
    public String getroot() {
        System.out.println("1234234");
        return "/Admin/index.html";
    }
}
