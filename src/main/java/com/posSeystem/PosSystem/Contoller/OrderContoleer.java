package com.posSeystem.PosSystem.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.posSeystem.PosSystem.Entity.Order;
import com.posSeystem.PosSystem.Service.OrderService;



@RestController
@CrossOrigin(origins = "*")
public class OrderContoleer {
    
   @Autowired
   private OrderService orderService;

   @PostMapping("/oders")
   public ResponseEntity<Order> creatOrder(@RequestBody Order entity) {


    System.out.println(entity.getNetAmount());
                Order od1 = new Order();
                od1.setQuantity(entity.getQuantity());
                od1.setNetAmount(entity.getNetAmount());


                Order order2= orderService.creatOrder(od1);
                return ResponseEntity.status(201).body(order2);


   }
   


}
