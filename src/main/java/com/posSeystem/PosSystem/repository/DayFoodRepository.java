package com.posSeystem.PosSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.posSeystem.PosSystem.Entity.DayFood;
@Repository
public interface DayFoodRepository extends JpaRepository<DayFood,Long> {
    

    @Modifying
    @Transactional
    @Query("UPDATE DayFood d SET d.isAvailable = :isAvailable WHERE d.id = :id")
    void updateAvailability(@Param("id") Long id, @Param("isAvailable") boolean isAvailable);

    @Query(value = "SELECT d.* FROM day_food d JOIN product p ON d.product_id = p.id WHERE p.category_id = :categoryId AND d.is_available = true", nativeQuery = true)
    List<DayFood> findAvailableDayFoodByCategory(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT d.* FROM day_food d JOIN product p ON d.product_id = p.id WHERE p.category_id = :categoryId AND d.is_available = true", nativeQuery = true)
    List<DayFood> findAvailableDayFoodlaunch(@Param("categoryId") Long categoryId);
     
}
