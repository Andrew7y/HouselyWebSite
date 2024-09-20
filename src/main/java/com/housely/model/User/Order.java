<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/Order.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/Order.java


import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
   
    private Long orderId;
    private LocalDateTime orderDate;
    private String paymentStatus;
    private double totalAmount;
    private CreditCard creditCard;
    private Customer customer;
    private List<OrderItem> orderItems;
    private PaymentAddress paymentAddress;
    private Shipping shipping;

}
