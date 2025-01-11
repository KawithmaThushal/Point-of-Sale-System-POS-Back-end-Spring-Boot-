package com.posSeystem.PosSystem.repository;

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
}
