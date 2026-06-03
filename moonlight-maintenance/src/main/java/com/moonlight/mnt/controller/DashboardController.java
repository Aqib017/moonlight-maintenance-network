package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.dto.DashboardSummaryResponse;
import com.moonlight.mnt.service.DashboardService;
@RestController
public class DashboardController {
	
	@Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard/{month}/{year}")
    public DashboardSummaryResponse getDashboardSummary(@PathVariable String month,@PathVariable Integer year) {

        return dashboardService.getDashboardSummary(month,year);
    }

}
