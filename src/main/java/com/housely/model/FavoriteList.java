package com.housely.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteList {
   
    private Long favoriteListId;
    private String favoriteListName;
    private Customer customer;
    private List<Product> productInFavoriteList;
}
