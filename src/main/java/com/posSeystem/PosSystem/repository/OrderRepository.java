package com.posSeystem.PosSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.posSeystem.PosSystem.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
    
    // Full Amount
    @Query(value = "SELECT SUM(full_amount) FROM orders", nativeQuery = true)
    Double findTotalFullAmount();

    // Total Full Items (JPQL)
    @Query("SELECT SUM(o.quantity) FROM Order o")
    Long findTotalFullItem();

    // Today's Total Amount
    @Query(value = "SELECT SUM(full_amount) FROM orders WHERE DATE(issues_date) = CURRENT_DATE", nativeQuery = true)
    Double findTodayTotalAmount();

    // Today's Total Items (JPQL)
    @Query("SELECT SUM(o.quantity) FROM Order o WHERE DATE(o.issuesDate) = CURRENT_DATE")
    Long findTodayTotalItem();

    // Today's Order Count (JPQL)
    @Query("SELECT COUNT(o) FROM Order o WHERE DATE(o.issuesDate) = CURRENT_DATE")
    Long countTodayOrders();


//     @Query("SELECT new com.posSeystem.PosSystem.DTO.AggregatedData(DATE(o.issuesDate), COUNT(o), SUM(o.fullAmount)) " +
//        "FROM Order o " +
//        "GROUP BY DATE(o.issuesDate) " +
//        "ORDER BY DATE(o.issuesDate)")
// List<Order> findDailyAggregatedData();
//     // Monthly Aggregated Data
//     @Query(value = "SELECT DATE_FORMAT(o.issues_date, '%Y-%m') AS month, COUNT(*) AS totalOrders, SUM(o.full_amount) AS totalAmount " +
//                    "FROM orders o " +
//                    "GROUP BY DATE_FORMAT(o.issues_date, '%Y-%m') " +
//                    "ORDER BY DATE_FORMAT(o.issues_date, '%Y-%m')", 
//            nativeQuery = true)
//     List<AggregatedData> findMonthlyAggregatedData();
}
