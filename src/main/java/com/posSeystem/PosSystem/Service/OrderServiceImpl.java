package com.posSeystem.PosSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Order;
import com.posSeystem.PosSystem.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order creatOrder(Order order) {
        return orderRepository.save(order);       
    }
    
}
