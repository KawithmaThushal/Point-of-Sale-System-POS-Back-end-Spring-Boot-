package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.DayFood;

@Service
public interface DayFoodService {

  

    List<DayFood> getItem();
    List<DayFood> getlunchItem();
    
}
