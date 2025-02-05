package com.posSeystem.PosSystem.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.Entity.Categery;
import com.posSeystem.PosSystem.Service.CategeryService;




@RestController
@CrossOrigin(origins = "*")
public class CategeryContoller {

    @Autowired
    private CategeryService categeryService;


    @GetMapping("/Categery")
    public ResponseEntity<List<Categery>> getAllCategery() {
            List<Categery> categeries= categeryService.getAllCategery();
            return ResponseEntity.status(200).body(categeries);
    }

    @PostMapping("/Categery")
    public ResponseEntity<Categery> creagtCategery(@RequestBody Categery categery) {
        Categery categery2 = categeryService.creatCategory(categery);

        return ResponseEntity.status(201).body(categery2);
    }

    @PutMapping("Categery/{id}")
    public ResponseEntity<Categery> updaqetCategory(@PathVariable Long id, @RequestBody Categery entity) {
        try {
            Categery categery= categeryService.getFindCategery(id);
            categery.setName(entity.getName());

            Categery categery2 = categeryService.updateCategory(id, categery);

            return ResponseEntity.status(200).body(categery2);

        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(500).build();

        }
    }

   // @DeleteMapping("Categery/{id}")
    
    
    
}
