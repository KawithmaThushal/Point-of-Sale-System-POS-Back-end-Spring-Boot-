package com.posSeystem.PosSystem.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.DTO.supleyrDto;
import com.posSeystem.PosSystem.Entity.Supplyer;
import com.posSeystem.PosSystem.Service.SupplyerService;


@RestController
public class SupplyerController {
    
    @Autowired
    private SupplyerService supplyerService;

    @PostMapping("/supleyr")
    public ResponseEntity<Supplyer> creatSuppler(@RequestBody supleyrDto entity) {
       
        try {
            System.out.println("Received request: " + entity);
            if (entity.getCname() == null || entity.getCname().isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
    
            Supplyer supplyer = new Supplyer();
            supplyer.setCname(entity.getCname());
            supplyer.setCNumber(entity.getCNumber());
            supplyer.setCAdress(entity.getCAdress());
            supplyer.setSupplersName(entity.getSupplersName());
            supplyer.setEmail(entity.getEmail());
    
            Supplyer createdSupplier = supplyerService.CreatSupplyer(supplyer);
            return ResponseEntity.status(201).body(createdSupplier);
    
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return ResponseEntity.status(500).build();
        }


    }
    



}
