package com.housely.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAddress {

    private Long paymentAddressId;
    private String firstName;
    private String lastName;
    private String streetAlleyVillage;
    private String country;
    private String city;
    private String houseNumber;
    private String state;
    private String zip;
    private String phone;
    private String district;
    private Order order;
    private Customer customer;
    
}
