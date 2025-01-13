package com.posSeystem.PosSystem.Entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AggregatedData {
    private LocalDate date;
    private Long totalOrders;
    private Double totalRevenue;
}
