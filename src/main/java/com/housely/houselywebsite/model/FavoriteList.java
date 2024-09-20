package com.housely.houselywebsite.model;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteList {
   
    private Long favoriteListId;
    private String favoriteListName;
    private Customer customer;
    private List<Product> productInFavoriteList;
    public void addProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProduct'");
    }
}
