package com.housely.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {

    private Long shippingAddressId;
    private String country;
    private String province;
    private String district;
    private String streetAlleyVillage;
    private String houseNumber;
    private String zip;
    private String phone;
    private Customer customer;
    
}
