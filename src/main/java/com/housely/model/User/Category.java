<<<<<<<< HEAD:src/main/java/com/housely/houselywebsite/model/Category.java
package com.housely.houselywebsite.model;
========
package com.housely.model.User;
>>>>>>>> 69d31dd441447ddb10b53b118de8f22cc4b1ff60:src/main/java/com/housely/model/User/Category.java

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private Long categoryId;
    private String categoryName;
    private String description;
    private String imageBase64;
    private List<Product> productInCategories;

}

