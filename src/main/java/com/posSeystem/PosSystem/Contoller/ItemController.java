package com.posSeystem.PosSystem.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.DTO.ItemDto;
import com.posSeystem.PosSystem.Entity.Categery;
import com.posSeystem.PosSystem.Entity.Item;
import com.posSeystem.PosSystem.Service.CategeryService;
import com.posSeystem.PosSystem.Service.ItemService;




@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategeryService categeryService;


    @GetMapping("/item")
    public ResponseEntity<List<Item>> getAllItem() {
        List<Item> items= itemService.gettAllItem();

        return ResponseEntity.status(200).body(items);
    }
    
    @PostMapping("/item")
    public ResponseEntity<Item> creatItem(@RequestBody ItemDto entity) {
        
        Item  item = new Item();
        item.setName(entity.getName());
        item.setDiscription(entity.getDiscription());
        item.setPrice(entity.getPrice());
        item.setQuantity(entity.getQuantity());
        item.setImage(entity.getImage());

        Categery categery = categeryService .getFindCategery(entity.getCategoryId());
        item.setCategory(categery);

        Item item2 = itemService.creatItem(item);

        return ResponseEntity.status(201).body(item2);


        
        
    }

    @PutMapping("item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemDto entity) {
            try {
                Item item = itemService.getItemId(id);
                item.setName(entity.getName());
                item.setDiscription(entity.getDiscription());
                item.setPrice(entity.getPrice());
                item.setQuantity(entity.getQuantity());
                item.setImage(entity.getImage());

                
        Categery categery = categeryService .getFindCategery(entity.getCategoryId());
        item.setCategory(categery);

        Item item2 = itemService.updateItem(id, item);

        return ResponseEntity.ok(item2);

    
            } catch (Exception e) {
               e.getMessage();
               return ResponseEntity.status(500).build();
            }
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> Deleteitem(@PathVariable  Long id){

        try {
            itemService.DeleteItem(id);
            return ResponseEntity.status(200).body("Delete sucessfull");
        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
            return ResponseEntity.status(500).body("Delete failed: " + e.getMessage());
        }

    }
    
    
}
