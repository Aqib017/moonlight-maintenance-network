package com.moonlight.mnt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.moonlight.mnt.service.ExcelImportService;
@RestController
@RequestMapping("/excel")
public class ExcelImportController {

    @Autowired
    private ExcelImportService service;

	@PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> importExcel(@RequestParam("file") MultipartFile file) {
		try {
			service.importMonthlySummary(file);
			return ResponseEntity.ok("Import Successful");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}