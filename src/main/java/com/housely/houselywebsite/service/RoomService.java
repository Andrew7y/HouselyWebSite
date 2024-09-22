package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Room;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;





@Service
public class RoomService {

    private final WebClient webClient;

    @Autowired
    public RoomService(WebClient webClient) {
        this.webClient = webClient;
    }

    // สร้างห้องใหม่ (POST)
    public Mono<Room> save(Room room) {
        return webClient.post()
            .uri("/rooms")
            .bodyValue(room)
            .retrieve()
            .bodyToMono(Room.class);
    }

    // ดึงห้องพักทั้งหมด (GET)
    public List<Room> findAll() {
        return webClient.get()
            .uri("/rooms")
            .retrieve()
            .bodyToFlux(Room.class)
            .collectList()
            .block();  // เนื่องจาก Controller เป็นแบบ synchronous, จึงใช้ block() เพื่อดึงค่ากลับมาเป็น List
    }

    // ดึงห้องพักตาม ID (GET)
    public Room findById(Long id) {
        return webClient.get()
            .uri("/rooms/{id}", id)
            .retrieve()
            .bodyToMono(Room.class)
            .block();  // ใช้ block() สำหรับ synchronous call
    }

    // อัปเดตห้องพักตาม ID (PUT)
    public Mono<Room> updateRoom(Long id, Room updatedRoom) {
        return webClient.put()
            .uri("/rooms/{id}", id)
            .bodyValue(updatedRoom)
            .retrieve()
            .bodyToMono(Room.class);
    }

    // ลบห้องพักตาม ID (DELETE)
    public void deleteById(Long id) {
        webClient.delete()
            .uri("/rooms/{id}", id)
            .retrieve()
            .toBodilessEntity()  // ไม่มีการตอบกลับเป็น Body
            .block();  // ใช้ block() เพื่อทำการลบแบบ synchronous
    }
}

