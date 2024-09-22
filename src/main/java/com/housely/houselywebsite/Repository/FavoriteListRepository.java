package com.housely.Repository;

import com.housely.Model.Favorite.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FavoriteListRepository extends JpaRepository<FavoriteList, Long> {
    @Query("SELECT b FROM FavoriteList b JOIN b.customer a WHERE b.favoriteListId = :favoriteListId AND a.id = :cusId")
    Optional<FavoriteList> findFavoriteInCustomerList(@Param("favoriteListId") Long favoriteListId, @Param("cusId") Long cusId);
}
