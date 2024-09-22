package com.housely.model.User;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
   
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private List<Review> reviews;
    private List<FavoriteList> favorites;
    private List<CreditCard> creditCards;
    private List<Order> orders;
    private PaymentAddress paymentAddress;
    private List<ShippingAddress> shippingAddresses;
    private Cart cart;


}
