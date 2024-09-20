<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/Shipping.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/Shipping.java

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

    private Long shippingId;
    private String targetFirstName;
    private String targetLastName;
    private String targetPhoneNumber;
    private String shippingStatus;
    private LocalDate shippingDate;
    private String shippingMethod;
    private String trackingNumber;
    private Order order;
}
