
package com.posSeystem.PosSystem.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quaitiy;
    
    private Double price;

    private Date expireDate;

     @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date addedDate;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
