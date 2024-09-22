package com.housely.Repository;

import com.housely.Model.Address.PaymentAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAddressRepository extends JpaRepository<PaymentAddress, Long> {
}
