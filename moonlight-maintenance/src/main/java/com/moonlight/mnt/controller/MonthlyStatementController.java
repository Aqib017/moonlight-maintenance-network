package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.dto.MonthlyStatementResponse;
import com.moonlight.mnt.service.MonthlyStatementService;
@RestController
public class MonthlyStatementController {
	
	@Autowired
	private MonthlyStatementService monthlyStatementService;
	
	@GetMapping("/statement/{month}/{year}")
	public MonthlyStatementResponse getMonthlyStatement(@PathVariable String month,@PathVariable Integer year) {
		return monthlyStatementService.getMonthlyStatement(month, year);
	}
}
