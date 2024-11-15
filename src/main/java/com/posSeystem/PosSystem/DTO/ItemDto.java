package com.posSeystem.PosSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemDto {

    private String name;

    private Double price;

    private String discription;

    private byte[] image;

    private Long quantity;
    private Long categoryId;
    
}
