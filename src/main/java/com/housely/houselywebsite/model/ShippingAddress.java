package com.housely.houselywebsite.model;

import java.time.LocalDate;

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
    private String targetFirstName;
    private String targetLastName;
    private String targetPhoneNumber;
    private String shippingStatus;
    private LocalDate shippingDate;
    private String shippingMethod;
    private String trackingNumber;
    private CustomerOrder customerOrder;
    private ShippingAddress shippingAddress;
    
}
