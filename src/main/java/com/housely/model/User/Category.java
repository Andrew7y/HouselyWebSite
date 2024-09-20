package com.housely.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

