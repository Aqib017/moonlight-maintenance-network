package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.moonlight.mnt.dto.MonthlyStatementResponse;
import com.moonlight.mnt.service.MonthlyStatementService;
import com.moonlight.mnt.service.PdfStatementService;
@RestController
public class MonthlyStatementController {
	
	@Autowired
	private MonthlyStatementService monthlyStatementService;
	
	@Autowired
	private PdfStatementService pdfStatementService;
	
	@GetMapping("/statement/{month}/{year}")
	public MonthlyStatementResponse getMonthlyStatement(@PathVariable String month,@PathVariable Integer year) {
		return monthlyStatementService.getMonthlyStatement(month, year);
	}
	@GetMapping("/statement/pdf/{month}/{year}")
	public ResponseEntity<byte[]> downloadPdf(@PathVariable String month, @PathVariable Integer year) throws Exception {
		byte[] pdf = pdfStatementService.generatePdf(month, year);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=statement-" + month + "-" + year + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).body(pdf);
	}
}
