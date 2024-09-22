package com.housely.model.User;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Long id;
    private String description;
    private String imageBase64;
    private String roomName;
    private List<Product> productInRooms;
    
}
