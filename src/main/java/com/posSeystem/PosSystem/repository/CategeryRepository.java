package com.posSeystem.PosSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Categery;

@Repository
public interface CategeryRepository extends JpaRepository<Categery,Long>{
    
}
