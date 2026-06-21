package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moonlight.mnt.service.ExcelExportService;
@RestController
public class ExportController {

    @Autowired
    private ExcelExportService excelExportService;

	@GetMapping("/export/collections")
	public ResponseEntity<byte[]> exportCollections() throws Exception {

		byte[] excel = excelExportService.exportCollections();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Collections.xlsx")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(excel);
	}
    
	@GetMapping("/export/expenses")
	public ResponseEntity<byte[]> exportExpenses() throws Exception {

		byte[] excel = excelExportService.exportExpenses();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Expenses.xlsx")
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(excel);
	}
}