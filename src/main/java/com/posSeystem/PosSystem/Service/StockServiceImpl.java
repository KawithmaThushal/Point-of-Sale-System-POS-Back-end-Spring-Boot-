package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.DayFood;
import com.posSeystem.PosSystem.Entity.Stock;
import com.posSeystem.PosSystem.repository.DayFoodRepository;
import com.posSeystem.PosSystem.repository.StockRepository;
@Service
public class StockServiceImpl implements StockService{

@Autowired
private StockRepository stockRepository;

@Autowired
private  DayFoodRepository dayFoodRepository;


    @Override
    public Stock createStock(Stock stock) {
       return  stockRepository.save(stock);
    }


    @Override
    public List<Stock> getStock() {
       return stockRepository.findAll();
    }


    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }


    @Override
    public DayFood createFood(DayFood dayFood) {
       return dayFoodRepository.save(dayFood);
    }


    @Override
    public List<DayFood> getDayFood() {
        return dayFoodRepository.findAll();
    }

    @Override
    public void toggleDayFoodAvailability(Long id, Boolean isAvailable) {
        // Fetch the DayFood entity by its ID
        DayFood dayFood = dayFoodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DayFood item with id " + id + " not found."));

        // Ensure the `isAvailable` value is not null
        if (isAvailable == null) {
            throw new IllegalArgumentException("Availability status cannot be null.");
        }

        // Update the isAvailable field
        dayFood.setIsAvailable(isAvailable);

        // Save the updated entity
        dayFoodRepository.save(dayFood);
    }


    @Override
    public void deleteDayStock(Long id) {
        dayFoodRepository.deleteById(id);
    }


    @Override
    public List<Stock> getBeverageItem() {
        Long BeveragetCategoryId = 3L; // Category ID for Breakfast
    List<Stock> items = stockRepository.findStockByBeverage(BeveragetCategoryId);

    if (items.isEmpty()) {
System.out.println("No breakfast items found.");    }

    return items;
    }


    @Override
    public List<Stock> getIceCreamItem() {
        Long IceCreamCategoryId = 5L; // Category ID for Breakfast
    List<Stock> items = stockRepository.findStockByIceCream(IceCreamCategoryId);

    if (items.isEmpty()) {
System.out.println("No breakfast items found.");    }

    return items;
    }


    @Override
    public List<Stock> getShortiesItem() {
        Long ShortiestCategoryId = 4L; // Category ID for Breakfast
        List<Stock> items = stockRepository.findStockByShorties(ShortiestCategoryId);
    
        if (items.isEmpty()) {
    System.out.println("No breakfast items found.");    }
    
        return items;
    }


    @Override
    public List<Stock> getLowQuantityStock() {
        return stockRepository.findLowQuantity();
    }

   

  
}
