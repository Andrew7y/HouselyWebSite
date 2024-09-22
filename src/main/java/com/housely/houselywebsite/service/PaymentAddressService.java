package com.housely.houselywebsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.housely.houselywebsite.model.PaymentAddress;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentAddressService {

    private final WebClient webClient;

    @Autowired
    public PaymentAddressService(WebClient webClient) {
        this.webClient = webClient;
    }

        // Fetch all payment addresses (assuming API call)
    public Flux<PaymentAddress> findAll() {
        return webClient.get()
            .uri("/payment-addresses")
            .retrieve()
            .bodyToFlux(PaymentAddress.class); // Expect multiple PaymentAddress objects
    }

    // Save a new payment address via POST request
    public Mono<PaymentAddress> save(PaymentAddress paymentAddress) {
        return webClient.post()
            .uri("/payment-addresses")
            .bodyValue(paymentAddress) // Send paymentAddress object as body
            .retrieve()
            .bodyToMono(PaymentAddress.class); // Expect one PaymentAddress object in response
    }

    // Find payment address by ID via GET request
    public Mono<PaymentAddress> findById(Long id) {
        return webClient.get()
            .uri("/payment-addresses/{id}", id)
            .retrieve()
            .bodyToMono(PaymentAddress.class) // Expect one PaymentAddress object in response
            .switchIfEmpty(Mono.error(new RuntimeException("PaymentAddress not found")));
    }

    // Delete payment address by ID via DELETE request
    public Mono<Void> deleteById(Long id) {
        return webClient.delete()
            .uri("/payment-addresses/{id}", id)
            .retrieve()
            .bodyToMono(Void.class); // No body in response for DELETE
    }
    // // สร้าง RestTemplate สำหรับทำการเรียก API
    // private final RestTemplate restTemplate;
    
    // // URL สำหรับเรียก API ของระบบการชำระเงิน
    // private final String baseUrl = "http://localhost:8085/api/payments";

    // // Constructor สำหรับ inject RestTemplate
    // public PaymentService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

    // // ฟังก์ชันสำหรับสร้างการชำระเงินใหม่
    // public Payment createPayment(Payment payment) {
    //     // เรียก API เพื่อ POST ข้อมูลการชำระเงินใหม่
    //     ResponseEntity<Payment> response = restTemplate.exchange(
    //         baseUrl,  // URL ปลายทาง
    //         HttpMethod.POST,  // HTTP method ใช้ POST
    //         new HttpEntity<>(payment),  // ใส่ข้อมูล Payment ลงไปใน request body
    //         new ParameterizedTypeReference<Payment>() {}  // ระบุชนิดของข้อมูลที่จะตอบกลับ
    //     );
    //     // คืนค่าข้อมูลการชำระเงินที่ถูกสร้างใหม่
    //     return response.getBody();
    // }

    // // ฟังก์ชันสำหรับดึงข้อมูลการชำระเงินตาม ID
    // public Payment getPaymentById(Long id) {
    //     // เรียก API เพื่อ GET ข้อมูลการชำระเงินตาม ID
    //     ResponseEntity<Payment> response = restTemplate.exchange(
    //         baseUrl + "/" + id,  // URL ปลายทางรวม ID ของ Payment
    //         HttpMethod.GET,  // HTTP method ใช้ GET
    //         null,  // ไม่ต้องการ request body
    //         new ParameterizedTypeReference<Payment>() {}  // ระบุชนิดของข้อมูลที่จะตอบกลับ
    //     );
    //     // คืนค่าข้อมูลการชำระเงินตาม ID
    //     return response.getBody();
    // }

    // // ฟังก์ชันสำหรับอัปเดตข้อมูลการชำระเงินตาม ID
    // public Payment updatePayment(Long id, Payment payment) {
    //     // เรียก API เพื่อ PUT ข้อมูลการชำระเงินที่อัปเดตแล้ว
    //     ResponseEntity<Payment> response = restTemplate.exchange(
    //         baseUrl + "/" + id,  // URL ปลายทางรวม ID ของ Payment ที่จะอัปเดต
    //         HttpMethod.PUT,  // HTTP method ใช้ PUT
    //         new HttpEntity<>(payment),  // ใส่ข้อมูล Payment ที่อัปเดตลงไปใน request body
    //         new ParameterizedTypeReference<Payment>() {}  // ระบุชนิดของข้อมูลที่จะตอบกลับ
    //     );
    //     // คืนค่าข้อมูลการชำระเงินที่ถูกอัปเดต
    //     return response.getBody();
    // }

    // // ฟังก์ชันสำหรับลบข้อมูลการชำระเงินตาม ID
    // public void deletePayment(Long id) {
    //     // เรียก API เพื่อ DELETE ข้อมูลการชำระเงินตาม ID
    //     restTemplate.exchange(
    //         baseUrl + "/" + id,  // URL ปลายทางรวม ID ของ Payment ที่จะลบ
    //         HttpMethod.DELETE,  // HTTP method ใช้ DELETE
    //         null,  // ไม่ต้องการ request body
    //         new ParameterizedTypeReference<Void>() {}  // ไม่มีข้อมูลตอบกลับ
    //     );
    // }
}

