package com.housely.Repository;

import com.housely.Model.Card.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, String> {
    Optional<CreditCard> findByCreditCardNumber(String creditCardNumber);
    void deleteByCreditCardNumber(String creditCardNumber);
}
