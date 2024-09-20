package com.housely.model.User;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    private String creditCartNumber;
    private String yearExp;
    private String monthExp;
    private String CVV;
    private List<Customer> customers;
    private List<Order> orders;




}

