package com.housely.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Long reviewId;
    private double rating;
    private String comment;
    private LocalDate dateReview;
    private Customer customer;
    private Product product;
    
}
