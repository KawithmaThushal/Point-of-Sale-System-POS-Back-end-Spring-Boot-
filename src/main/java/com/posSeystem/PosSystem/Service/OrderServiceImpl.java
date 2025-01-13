package com.posSeystem.PosSystem.Service;

import java.util.List;

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

    @Override
    public List<Order> getOders() {
       return orderRepository.findAll();
    }

    @Override
    public Double findFullAmount() {
       return orderRepository.findTotalFullAmount();
    }

    @Override
    public Long findFullItem() {
        return orderRepository.findTotalFullItem();
    }

    @Override
    public Double findtodayAmount() {
       return orderRepository.findTodayTotalAmount();
    }

    @Override
    public Long findtodayItem() {
        return orderRepository.findTodayTotalItem();
    }

    @Override
    public Long findcountOders() {
        return orderRepository.countTodayOrders();
    }

    // @Override
    // public List<AggregatedData> getDailyData() {
    //     return orderRepository.findDailyAggregatedData();
    // }

    // @Override
    // public List<AggregatedData> getMonthlyData() {
    //     return orderRepository.findMonthlyAggregatedData();

    // }
    
}
