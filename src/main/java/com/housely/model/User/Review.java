<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/Review.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/Review.java

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Long reviewId;
    private double rating;
    private String comment;
    private LocalDate dateReview;
    private Customer customer;
    private Product product;
    
}
