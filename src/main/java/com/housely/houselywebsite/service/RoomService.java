package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Room;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RoomService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/rooms";

    public RoomService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // สร้างข้อมูลห้องใหม่
    public Room createRoom(Room room) {
        ResponseEntity<Room> response = restTemplate.exchange(
            baseUrl, HttpMethod.POST, new HttpEntity<>(room),
            new ParameterizedTypeReference<Room>() {});
        return response.getBody();
    }

    // ดึงข้อมูลห้องตาม ID
    public Room getRoomById(Long id) {
        ResponseEntity<Room> response = restTemplate.exchange(
            baseUrl + "/" + id, HttpMethod.GET, null,
            new ParameterizedTypeReference<Room>() {});
        return response.getBody();
    }

    // ลบข้อมูลห้องตาม ID
    public void deleteRoom(Long id) {
        restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, null, 
            new ParameterizedTypeReference<Void>() {});
    }
}

