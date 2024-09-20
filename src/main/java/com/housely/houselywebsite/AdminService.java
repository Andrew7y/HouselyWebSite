// package com.housely.houselywebsite;

// import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// @Service
// public class AdminService {
    
//     private final RestTemplate restTemplate;
//     private String baseUrl = "http://localhost:8085/api/authors";

//     // Constructor ที่ใช้สำหรับ Inject RestTemplate เข้าสู่ AdminService
//     public AdminService(RestTemplate restTemplate) {
//         this.restTemplate = restTemplate;
//     }

//     // เมธอดสำหรับดึงข้อมูล admin ตาม ID
//     public Admin getAdminById(Long id) {
//         // ใช้ restTemplate.getForObject เพื่อดึงข้อมูลจาก API ตาม ID ที่กำหนด
//         return restTemplate.getForObject(
//                 baseUrl + "/" + id, // URL ของ API สำหรับดึงข้อมูล admin ตาม ID
//                 Admin.class // ประเภทของข้อมูลที่คาดว่าจะได้รับจาก API
//         );
//     }





    

// }
