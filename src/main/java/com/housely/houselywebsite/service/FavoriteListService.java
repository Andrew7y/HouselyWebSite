package com.housely.houselywebsite.service;

import com.housely.houselywebsite.model.FavoriteList;
import com.housely.houselywebsite.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FavoriteListService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8085/api/favorites";

    public FavoriteListService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FavoriteList createFavoriteList(FavoriteList favoriteList) {
        ResponseEntity<FavoriteList> response = restTemplate.exchange(
            baseUrl, HttpMethod.POST, new HttpEntity<>(favoriteList),
            new ParameterizedTypeReference<FavoriteList>() {});
        return response.getBody();
    }

    public FavoriteList getFavoriteListById(Long id) {
        ResponseEntity<FavoriteList> response = restTemplate.exchange(
            baseUrl + "/" + id, HttpMethod.GET, null,
            new ParameterizedTypeReference<FavoriteList>() {});
        return response.getBody();
    }

    public void deleteFavoriteList(Long id) {
        restTemplate.exchange(baseUrl + "/" + id, HttpMethod.DELETE, null, 
            new ParameterizedTypeReference<Void>() {});
    }

    public void addProductToFavorite(Long favoriteListId, Product product) {
        FavoriteList favoriteList = favoriteListRepository.findById(favoriteListId)
                .orElseThrow(() -> new RuntimeException("Favorite List not found"));
        favoriteList.addProduct(product);
        favoriteListRepository.save(favoriteList);
    }

    public void removeProductFromFavorite(Long favoriteListId, Product product) {
        FavoriteList favoriteList = favoriteListRepository.findById(favoriteListId)
                .orElseThrow(() -> new RuntimeException("Favorite List not found"));
        favoriteList.removeProduct(product);
        favoriteListRepository.save(favoriteList);
    }
}

