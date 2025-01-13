package com.posSeystem.PosSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.posSeystem.PosSystem.Entity.Order;

@Service
public interface OrderService {

    Order creatOrder(Order order);
    List<Order> getOders();

    Double findFullAmount();
    Long findFullItem();
    Double findtodayAmount();
    Long findtodayItem();
    Long findcountOders();

    //  List<AggregatedData> getDailyData();
    //  List<AggregatedData> getMonthlyData();

    
}
