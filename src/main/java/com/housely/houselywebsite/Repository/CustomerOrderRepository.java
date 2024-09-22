package com.housely.Repository;

import com.housely.Model.Order.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    @Query("SELECT co FROM CustomerOrder co " +
            "JOIN co.customer c " +
            "WHERE c.id = :cusId AND co.orderId = :orderId")
    Optional<CustomerOrder> findCustomerOrderByCustomerAndOrderId(@Param("cusId") Long cusId,
                                                                  @Param("orderId") Long orderId);

    @Query("SELECT co FROM CustomerOrder co " +
            "JOIN co.customer c " +
            "WHERE c.id = :cusId")
    List<CustomerOrder> findCustomerOrdersByCustomerId(@Param("cusId") Long cusId);
}
