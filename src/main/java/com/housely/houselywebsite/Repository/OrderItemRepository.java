package com.housely.Repository;

import com.housely.Model.Order.OrderItem;
import com.housely.Model.Order.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("SELECT oi FROM OrderItem oi " +
            "JOIN oi.customerOrder co " +
            "JOIN co.customer c " +
            "WHERE c.id = :cusId AND co.orderId = :orderId AND oi.orderItemId = :itemId")
    Optional<OrderItem> findOrderItemByCustomerAndOrder(@Param("cusId") Long cusId,
                                                        @Param("orderId") Long orderId,
                                                        @Param("itemId") OrderItemKey itemId);

    @Query("SELECT oi FROM OrderItem oi " +
            "JOIN oi.customerOrder co " +
            "JOIN co.customer c " +
            "WHERE c.id = :cusId AND co.orderId = :orderId")
    List<OrderItem> findOrderItemsByCustomerAndOrder(@Param("cusId") Long cusId,
                                                     @Param("orderId") Long orderId);
}
