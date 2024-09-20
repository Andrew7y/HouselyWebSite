<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/PaymentAddress.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/PaymentAddress.java

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
