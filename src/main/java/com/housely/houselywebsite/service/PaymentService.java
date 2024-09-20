package com.housely.houselywebsite.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    // สร้าง RestTemplate สำหรับทำการเรียก API
    private final RestTemplate restTemplate;
    
    // URL สำหรับเรียก API ของระบบการชำระเงิน
    private final String baseUrl = "http://localhost:8085/api/payments";

    // Constructor สำหรับ inject RestTemplate
    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // ฟังก์ชันสำหรับสร้างการชำระเงินใหม่
    public Payment createPayment(Payment payment) {
        // เรียก API เพื่อ POST ข้อมูลการชำระเงินใหม่
        ResponseEntity<Payment> response = restTemplate.exchange(
            baseUrl,  // URL ปลายทาง
            HttpMethod.POST,  // HTTP method ใช้ POST
            new HttpEntity<>(payment),  // ใส่ข้อมูล Payment ลงไปใน request body
            new ParameterizedTypeReference<Payment>() {}  // ระบุชนิดของข้อมูลที่จะตอบกลับ
        );
        // คืนค่าข้อมูลการชำระเงินที่ถูกสร้างใหม่
        return response.getBody();
    }

    // ฟังก์ชันสำหรับดึงข้อมูลการชำระเงินตาม ID
    public Payment getPaymentById(Long id) {
        // เรียก API เพื่อ GET ข้อมูลการชำระเงินตาม ID
        ResponseEntity<Payment> response = restTemplate.exchange(
            baseUrl + "/" + id,  // URL ปลายทางรวม ID ของ Payment
            HttpMethod.GET,  // HTTP method ใช้ GET
            null,  // ไม่ต้องการ request body
            new ParameterizedTypeReference<Payment>() {}  // ระบุชนิดของข้อมูลที่จะตอบกลับ
        );
        // คืนค่าข้อมูลการชำระเงินตาม ID
        return response.getBody();
    }

    // ฟังก์ชันสำหรับอัปเดตข้อมูลการชำระเงินตาม ID
    public Payment updatePayment(Long id, Payment payment) {
        // เรียก API เพื่อ PUT ข้อมูลการชำระเงินที่อัปเดตแล้ว
        ResponseEntity<Payment> response = restTemplate.exchange(
            baseUrl + "/" + id,  // URL ปลายทางรวม ID ของ Payment ที่จะอัปเดต
            HttpMethod.PUT,  // HTTP method ใช้ PUT
            new HttpEntity<>(payment),  // ใส่ข้อมูล Payment ที่อัปเดตลงไปใน request body
            new ParameterizedTypeReference<Payment>() {}  // ระบุชนิดของข้อมูลที่จะตอบกลับ
        );
        // คืนค่าข้อมูลการชำระเงินที่ถูกอัปเดต
        return response.getBody();
    }

    // ฟังก์ชันสำหรับลบข้อมูลการชำระเงินตาม ID
    public void deletePayment(Long id) {
        // เรียก API เพื่อ DELETE ข้อมูลการชำระเงินตาม ID
        restTemplate.exchange(
            baseUrl + "/" + id,  // URL ปลายทางรวม ID ของ Payment ที่จะลบ
            HttpMethod.DELETE,  // HTTP method ใช้ DELETE
            null,  // ไม่ต้องการ request body
            new ParameterizedTypeReference<Void>() {}  // ไม่มีข้อมูลตอบกลับ
        );
    }
}

