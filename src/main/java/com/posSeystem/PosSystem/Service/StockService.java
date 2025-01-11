package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.DayFood;
import com.posSeystem.PosSystem.Entity.Stock;
@Service
public interface StockService {


    List<Stock> getStock();
    Stock createStock(Stock stock);
     void deleteStock(Long id);

     DayFood createFood(DayFood dayFood);
     List<DayFood> getDayFood();
     void toggleDayFoodAvailability(Long id, Boolean isAvailable);
     void deleteDayStock(Long id);

    
}
