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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.DTO.ProductDto;
import com.posSeystem.PosSystem.Entity.Categery;
import com.posSeystem.PosSystem.Entity.Product;
import com.posSeystem.PosSystem.Service.CategeryService;
import com.posSeystem.PosSystem.Service.Productservice;





@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private Productservice productservice;
    @Autowired
    private CategeryService categeryService;
   

    @GetMapping("/Product")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> products = productservice.geProducts();

        return ResponseEntity.status(200).body(products);
    }

    @GetMapping("/Product/type")
    public ResponseEntity<List<Product>> getfoodType(@RequestParam String type) {
        return ResponseEntity.ok(productservice.getProductsByType(type));
        
    }
    
    


    

    @PostMapping("/Product")
    public ResponseEntity<Product> creatProduct(@RequestBody ProductDto entity) {

        try {
            // Map DTO to Product entity
            Product product = new Product();
            product.setProductname(entity.getProductname());
            product.setFoodType(entity.getFoodType());
            product.setImage(entity.getImage());

            // Get and validate category
            Categery categery = categeryService.getFindCategery(entity.getCategoryId());
            if (categery == null) {
                return ResponseEntity.badRequest().build();
            }
            product.setCategory(categery);

            // Save product
            Product createdProduct = productservice.creatProduct(product);
            return ResponseEntity.status(201).body(createdProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
       
      
        
    }
    

    @PutMapping("Product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto entity) {
       try {
        Product product = new Product();
        product.setProductname(entity.getProductname());

        Categery categery = categeryService.getFindCategery(entity.getCategoryId());   
        product.setFoodType(entity.getFoodType()); // Set foodType
        product.setImage(entity.getImage());

        product.setCategory(categery);

        Product product2= productservice.updateProduct(id, product);

        return ResponseEntity.ok(product2);

       } catch (Exception e) {
        e.getMessage();
        return ResponseEntity.status(500).build();       }
    }

    @DeleteMapping("/Product/{id}")
    public ResponseEntity<String> DeleteStock(@PathVariable  Long id){
        try {
            productservice.deleteproduct(id);
            return ResponseEntity.status(200).body("Delete Successfull");
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(500).build();        }
    }

    

 


    
}
