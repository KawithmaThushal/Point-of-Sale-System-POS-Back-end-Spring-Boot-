package com.posSeystem.PosSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query(value = "SELECT s.* FROM stock s JOIN product p ON s.product_id = p.id WHERE p.category_id = 3 AND s.quaitiy > 0",nativeQuery = true)
        List<Stock> findStockByBeverage(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT s.* FROM stock s JOIN product p ON s.product_id = p.id WHERE p.category_id = 4 AND s.quaitiy > 0",nativeQuery = true)
    List<Stock> findStockByShorties(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT s.* FROM stock s JOIN product p ON s.product_id = p.id WHERE p.category_id = 5 AND s.quaitiy > 0",nativeQuery = true)
    List<Stock> findStockByIceCream(@Param("categoryId") Long categoryId);
    
    @Query(value ="SELECT * FROM stock WHERE quaitiy <= 5 ",nativeQuery = true)
    List<Stock> findLowQuantity();
} 