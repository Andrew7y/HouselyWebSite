package com.housely.houselywebsite.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String productCode ;
    private String brandName ;
    private String productName ;
    private String price;
    private String color;
    private String size;
    private int quantity;
    private String imageBase64;
    private String description;
    private List<Review> reviews;
    private List<Room> rooms;
    private List<Category> categories;
    private List<FavoriteList> favoriteLists;
    private List<CartItem> cartItems;
    private List<OrderItem> orderItems;

}
