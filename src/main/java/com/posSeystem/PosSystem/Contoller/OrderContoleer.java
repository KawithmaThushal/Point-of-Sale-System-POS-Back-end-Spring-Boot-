package com.posSeystem.PosSystem.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
                od1.setBalance(entity.getBalance());
                od1.setCash(entity.getCash());
                od1.setDiscount(entity.getDiscount());
                od1.setServiceCharge(entity.getServiceCharge());
                od1.setOderType(entity.getOderType());
                od1.setProductIds(entity.getProductIds());
                od1.setFullAmount(entity.getFullAmount());
                Order order2= orderService.creatOrder(od1);
                System.out.println(od1);
                return ResponseEntity.status(201).body(order2);

         
   }

   @GetMapping("/oders")
   public ResponseEntity<List<Order>> getOrdersName() {
      List<Order> orders = orderService.getOders();

      return ResponseEntity.status(200).body(orders);
   }
   

   @GetMapping("/fullamount")
   public ResponseEntity<Double> getfullamount() {
       double totalamount = orderService.findFullAmount();

       return ResponseEntity.status(200).body(totalamount);
   }

   @GetMapping("/fullItems")
   public ResponseEntity<Long> getfullItems() {
      Long totalaItems = orderService.findFullItem();

       return ResponseEntity.status(200).body(totalaItems);
   }

   @GetMapping("/fullTodayAmunt")
   public ResponseEntity<Double> getfullTodayAmunt() {
       double totalTodayamount = orderService.findtodayAmount();

       return ResponseEntity.status(200).body(totalTodayamount);
   }

   @GetMapping("/fullTodayItems")
   public ResponseEntity<Long> getfullTodayItems() {
       Long totalItems = orderService.findtodayItem();

       return ResponseEntity.status(200).body(totalItems);
   }

   @GetMapping("/fullcountTody")
   public ResponseEntity<Long> getcountTody() {
       Long totalamount = orderService.findcountOders();

       return ResponseEntity.status(200).body(totalamount);
   }


   
   


}
