package com.posSeystem.PosSystem.Service;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Order;

@Service
public interface OrderService {

    Order creatOrder(Order order);

    
}
