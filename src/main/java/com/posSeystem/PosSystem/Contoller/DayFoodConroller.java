package com.posSeystem.PosSystem.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.Entity.DayFood;
import com.posSeystem.PosSystem.Entity.Stock;
import com.posSeystem.PosSystem.Service.DayFoodService;
import com.posSeystem.PosSystem.Service.StockService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dayfood")
public class DayFoodConroller {

     @Autowired
    private DayFoodService dayFoodService;

    @Autowired
    private StockService stockService;

    @GetMapping("/breakfast")
    public ResponseEntity<List<DayFood>> getBreakfastItems() {

          List<DayFood> dayFoods = dayFoodService.getItem();

        return ResponseEntity.status(200).body(dayFoods);
    }

    @GetMapping("/lunch")
    public ResponseEntity<List<DayFood>> getlunchItems() {

          List<DayFood> dayFoods = dayFoodService.getlunchItem();

        return ResponseEntity.status(200).body(dayFoods);
    }

    @GetMapping("/Beverage")
    public ResponseEntity<List<Stock>> getBeverageItems() {

          List<Stock> stocks = stockService.getBeverageItem();

        return ResponseEntity.status(200).body(stocks);
    }

    @GetMapping("/Shortets")
    public ResponseEntity<List<Stock>> getShortietsItems() {

          List<Stock> stocks = stockService.getShortiesItem();

        return ResponseEntity.status(200).body(stocks);
    }

    @GetMapping("/IceCream")
    public ResponseEntity<List<Stock>> getIceCreamItems() {

          List<Stock> stocks = stockService.getIceCreamItem();

        return ResponseEntity.status(200).body(stocks);
    }

    @GetMapping("/lowQuantity")
    public ResponseEntity<List<Stock>> getLowQEntity() {

          List<Stock> stocks = stockService.getLowQuantityStock();

        return ResponseEntity.status(200).body(stocks);
    }





    
}
