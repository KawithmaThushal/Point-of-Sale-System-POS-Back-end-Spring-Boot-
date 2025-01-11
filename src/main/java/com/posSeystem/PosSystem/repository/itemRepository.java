package com.posSeystem.PosSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Item;
@Repository
public interface itemRepository extends JpaRepository<Item,Long>{

  
    List<Item> findByCategoryId(Long categoryId);
    
}
