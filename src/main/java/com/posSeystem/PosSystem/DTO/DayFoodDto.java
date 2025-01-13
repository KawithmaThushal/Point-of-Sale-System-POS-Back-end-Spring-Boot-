package com.posSeystem.PosSystem.DTO;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DayFoodDto {
    
    private Double price; 

    private Boolean isAvailable; 

    private Long productId; 

    private Timestamp updatedAt;

    private Timestamp createdAt;


    private String productName;
    private Long productCategoryId;



   
}
