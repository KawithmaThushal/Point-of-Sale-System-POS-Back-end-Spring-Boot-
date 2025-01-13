package com.posSeystem.PosSystem.Contoller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = ("*"))
@RequestMapping("/analytics")
public class AnalyticsController {

    // @Autowired
    // private OrderService orderService;


    //  @GetMapping("/dailydata")
    // public ResponseEntity<List<AggregatedData>> getDailyData() {
    //         List<AggregatedData> aggregatedDatas = orderService.getDailyData();

    //     return ResponseEntity.ok(aggregatedDatas);
    // }

    // @GetMapping("/monthlydata")
    // public ResponseEntity<List<AggregatedData>> getMonthlyData() {
    //     List<AggregatedData> aggregatedMonethDatas = orderService.getMonthlyData();

    //     return ResponseEntity.ok(aggregatedMonethDatas);
    // }
    
}
