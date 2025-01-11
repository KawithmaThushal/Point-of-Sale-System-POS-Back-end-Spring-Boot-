package com.posSeystem.PosSystem.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {

    private Long quaitiy;

    //private Date addedDate;

    private Date expireDate;


    private Long productid;

    private Double price;
    
}
