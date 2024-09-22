package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.Room;

import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class RoomService {

    private final WebClient webClient;

    @Autowired
    public RoomService(WebClient webClient) {
        this.webClient = webClient;
    }

    // Fetch all rooms (assuming API call)
    public Mono<List<Room>> findAll() {
        return webClient.get()
            .uri("/rooms")
            .retrieve()
            .bodyToFlux(Room.class)  // Expect multiple Room objects
            .collectList();          // Convert Flux to List
    }

    // Save a new room via POST request
    public Mono<Room> save(Room room) {
        return webClient.post()
            .uri("/rooms")
            .bodyValue(room)          // Send room object as body
            .retrieve()
            .bodyToMono(Room.class);  // Expect one Room object in response
    }

    // Find room by ID via GET request
    public Mono<Room> findById(Long id) {
        return webClient.get()
            .uri("/rooms/{id}", id)
            .retrieve()
            .bodyToMono(Room.class)   // Expect one Room object in response
            .switchIfEmpty(Mono.error(new RuntimeException("Room not found")));
    }

    // Delete room by ID via DELETE request
    public Mono<Void> deleteById(Long id) {
        return webClient.delete()
            .uri("/rooms/{id}", id)
            .retrieve()
            .bodyToMono(Void.class);  // No body in response for DELETE
    }

    // private final RestTemplate restTemplate;
    // private final String baseUrl = "http://localhost:8085/api/rooms";

    // public RoomService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

    // // สร้างข้อมูลห้องใหม่
    // public Room createRoom(Room room) {
    //     ResponseEntity<Room> response = restTemplate.exchange(
    //         baseUrl, HttpMethod.POST, new HttpEntity<>(room),
    //         new ParameterizedTypeReference<Room>() {});
    //     return response.getBody();
    // }

    // // ดึงข้อมูลห้องตาม ID
    // public Room getRoomById(Long id) {
    //     ResponseEntity<Room> response = restTemplate.exchange(
    //         baseUrl + "/" + id, HttpMethod.GET, null,
    //         new ParameterizedTypeReference<Room>() {});
    //     return response.getBody();
    // }

    // // ลบข้อมูลห้องตาม ID
    // public void deleteRoom(Long id) {
    //     restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, null, 
    //         new ParameterizedTypeReference<Void>() {});
    // }
}

