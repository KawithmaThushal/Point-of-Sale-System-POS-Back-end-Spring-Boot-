package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.DayFood;
import com.posSeystem.PosSystem.repository.DayFoodRepository;
@Service
public class DayFoodServiceImpl implements DayFoodService {
      @Autowired
    private DayFoodRepository dayFoodRepository;

    @Override
    public List<DayFood> getItem() {
         Long breakfastCategoryId = 1L; // Category ID for Breakfast
    List<DayFood> items = dayFoodRepository.findAvailableDayFoodByCategory(breakfastCategoryId);

    if (items.isEmpty()) {
System.out.println("No breakfast items found.");    }

    return items;
       
    }

    @Override
    public List<DayFood> getlunchItem() {
        Long breakfastCategoryId = 2L; // Category ID for Breakfast
    List<DayFood> items = dayFoodRepository.findAvailableDayFoodlaunch(breakfastCategoryId);

    if (items.isEmpty()) {
System.out.println("No breakfast items found.");    }

    return items;
       
    }


    
}
