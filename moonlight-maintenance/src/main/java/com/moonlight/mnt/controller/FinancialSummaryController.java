package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.dto.FinancialSummaryResponse;
import com.moonlight.mnt.service.FinancialSummaryService;
@RestController
@RequestMapping("/financial-summary")
public class FinancialSummaryController {

	@Autowired
	private FinancialSummaryService financialSummaryService;

	@GetMapping("/{month}/{year}")
	public FinancialSummaryResponse getFinancialSummary(@PathVariable String month, @PathVariable Integer year) {
		return financialSummaryService.getFinancialSummary(month, year);
	}

}
