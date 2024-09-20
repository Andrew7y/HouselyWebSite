<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/OrderItem.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/OrderItem.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
 
    private OrderItemKey orderItemId;
    private int quantity;
    private Order order;
    private Product product;

}

