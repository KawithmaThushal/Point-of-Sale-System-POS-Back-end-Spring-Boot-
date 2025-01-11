package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Product;

@Service
public interface Productservice {

    List<Product> geProducts();
    Product creatProduct(Product product);
    void deleteproduct(Long id);
    Product updateProduct(Long id, Product product);
     Product getFindProduct(Long id);
     List<Product> getProductsByType(String foodType);


    
}
