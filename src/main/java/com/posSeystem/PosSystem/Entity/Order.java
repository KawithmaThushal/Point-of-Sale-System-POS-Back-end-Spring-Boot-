package com.posSeystem.PosSystem.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@jakarta.persistence.Table(name = "orders") // Use a different table name
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invNo;


    @Column(nullable = false)
    private float netAmount;

    @Column(nullable = false)
    private float ServiceCharge;

    private float Discount;

    private float Cash;

    private float Balance;

    private String OderType;

    @Column(nullable = false)
    private float FullAmount;

    @Column(columnDefinition = "TEXT") // Store JSON as text
    private Long[] productIds;

    @Column(nullable = false)
    private Long quantity;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime issuesDate;



    @PrePersist
    protected void onCreat(){
        if(issuesDate == null){
                this.issuesDate=LocalDateTime.now();
        }
    }
    
}
