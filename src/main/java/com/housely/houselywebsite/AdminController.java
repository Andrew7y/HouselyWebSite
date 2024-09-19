package com.housely.houselywebsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AdminController {
    
    @GetMapping("/Home")
    public String getLoginPage() {
        return "User/Home";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // เชื่อมต่อกับ database เพื่อเช็ค username กับ password
        // if ("admin".equals(username) && "password".equals(password)) {
        if ("admin".equals(username) && "password".equals(password)) {
            // ล็อกอินสำเร็จ ไปหน้า dashboard
            return new ModelAndView("redirect:Admin/dashboard");
        } else {
            // ล็อกอินล้มเหลว กลับไปที่หน้า login พร้อมข้อความผิดพลาด
            ModelAndView mav = new ModelAndView("Admin/login");
            mav.addObject("error", "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
            return mav;
        }
    }

    @GetMapping("/admin/customers")
    public String getCustomerPage() {
        return "Admin/customer";
    }

    

}
