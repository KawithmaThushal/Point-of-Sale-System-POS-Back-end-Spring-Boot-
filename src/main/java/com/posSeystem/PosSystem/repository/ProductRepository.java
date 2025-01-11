package com.posSeystem.PosSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByProductname(String productname);

        List<Product> findByFoodType(@Param("foodType") String foodType);


    
}
