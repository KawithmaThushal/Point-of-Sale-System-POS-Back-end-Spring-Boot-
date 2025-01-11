package com.posSeystem.PosSystem.Contoller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.DTO.DayFoodDto;
import com.posSeystem.PosSystem.DTO.StockDto;
import com.posSeystem.PosSystem.Entity.DayFood;
import com.posSeystem.PosSystem.Entity.Product;
import com.posSeystem.PosSystem.Entity.Stock;
import com.posSeystem.PosSystem.Service.Productservice;
import com.posSeystem.PosSystem.Service.StockService;



@RestController
@CrossOrigin(origins = "*")
public class StockController {
    

    @Autowired
    private StockService stokservice;

    @Autowired
    private Productservice productservice;

    


    @GetMapping("/Stock")
    public ResponseEntity<List<Stock>> getStock() {
        List<Stock> list = stokservice.getStock();


        return ResponseEntity.status(201).body(list);
    }


    @GetMapping("/DStock")
    public ResponseEntity<List<DayFood>> getDayFood() {
        List<DayFood> list = stokservice.getDayFood();


        return ResponseEntity.status(201).body(list);
    }


    

    @PostMapping("/Stock")
    public ResponseEntity<Stock> creatStock(@RequestBody StockDto entity) {
        
        Stock stock = new Stock();
        stock.setQuaitiy(entity.getQuaitiy());
        stock.setExpireDate(entity.getExpireDate());
        stock.setPrice(entity.getPrice());

        Product product = productservice.getFindProduct(entity.getProductid()); 
        stock.setProduct(product);
        
        stock.setAddedDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        Stock stock2 = stokservice.createStock(stock);

        return ResponseEntity.status(201).body(stock2);

        

    }
    @PostMapping("/DStock")
    public ResponseEntity<DayFood> creatDayStock(@RequestBody DayFoodDto entity) {
        
        DayFood Dstock = new DayFood();
        Dstock.setPrice(entity.getPrice());
        Dstock.setIsAvailable(entity.getIsAvailable());

        Product product = productservice.getFindProduct(entity.getProductId()); 
        Dstock.setProduct(product);
        
    Dstock.setCreatedAt(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

    DayFood  dayFood =stokservice.createFood(Dstock);


        return ResponseEntity.status(201).body(dayFood);

        

    }


     @DeleteMapping("/Stock/{id}")
    public ResponseEntity<String> DeleteStock(@PathVariable  Long id){
        try {
            stokservice.deleteStock(id);
            return ResponseEntity.status(200).body("Delete Successfull");
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(500).build();        }
    }

    @PatchMapping("/DStock/{id}/toggle")
    public ResponseEntity<String> toggleDayFoodAvailability(
            @PathVariable Long id,
            @RequestBody(required = false) Map<String, Boolean> requestBody) {
        try {
            if (requestBody == null || !requestBody.containsKey("isAvailable")) {
                return ResponseEntity.badRequest().body("Missing or invalid 'isAvailable' field in request body.");
            }

            boolean isAvailable = requestBody.get("isAvailable");
            stokservice.toggleDayFoodAvailability(id, isAvailable);
            return ResponseEntity.ok("Availability updated successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    @DeleteMapping("/DStock/{id}")
    public ResponseEntity<String> DeleteDayStock(@PathVariable  Long id){
        try {
            stokservice.deleteDayStock(id);
            return ResponseEntity.status(200).body("Delete Successfull");
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(500).build();        }
    }
    
}
