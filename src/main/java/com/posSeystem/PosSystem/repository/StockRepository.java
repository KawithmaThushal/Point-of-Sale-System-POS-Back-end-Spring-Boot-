package com.posSeystem.PosSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {


    
} 