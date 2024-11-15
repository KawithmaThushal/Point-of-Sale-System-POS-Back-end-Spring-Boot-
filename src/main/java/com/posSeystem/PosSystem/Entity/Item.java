package com.posSeystem.PosSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Item {

       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String discription;

    // how to add image data type
    @Lob
    private byte[] image;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Categery category;
    
}
