<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/CartItem.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/CartItem.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem {
   
    private CartItemKey id;
    private Product product;
    private Cart cart;
    private Long quantity;







}
