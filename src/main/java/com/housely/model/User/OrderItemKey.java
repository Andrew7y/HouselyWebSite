package com.housely.model.User;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemKey implements Serializable {
   
    private Long orderId;
    private Long productId;
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemKey that)) return false;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}

