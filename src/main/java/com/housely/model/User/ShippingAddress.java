<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/ShippingAddress.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/ShippingAddress.java

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
