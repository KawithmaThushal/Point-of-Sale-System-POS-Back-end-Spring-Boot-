package com.posSeystem.PosSystem.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Categery {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;


     @JsonIgnore

    @OneToMany(mappedBy = "category")
    private List<Item> items;

    @JsonIgnore

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    
    
}
