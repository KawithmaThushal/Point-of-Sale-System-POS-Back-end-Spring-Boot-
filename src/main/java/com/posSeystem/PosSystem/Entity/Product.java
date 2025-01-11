package com.posSeystem.PosSystem.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String productname;

    @Column
    private String image;

    @Column
    private String foodType; 

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Categery category;


     @JsonIgnore

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;

    
}
