package com.posSeystem.PosSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Supplyer;

@Repository
public interface SupplyerRepository extends JpaRepository<Supplyer,Long> {

    
} 
