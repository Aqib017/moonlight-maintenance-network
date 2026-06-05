package com.moonlight.mnt.service;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.moonlight.mnt.entity.MonthlySummary;
import com.moonlight.mnt.repository.MonthlySummaryRepository;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
@Service
public class ExcelImportService {
	
	@Autowired
	private MonthlySummaryRepository monthlySummaryRepository;

	public void importMonthlySummary(MultipartFile file) throws Exception {
		Workbook workbook = new XSSFWorkbook(file.getInputStream());
		Sheet sheet = workbook.getSheet("MonthlySummary");
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			MonthlySummary summary = new MonthlySummary();
			summary.setMonth(row.getCell(0).getStringCellValue());
			summary.setYear((int) row.getCell(1).getNumericCellValue());
			summary.setOpeningBalance(row.getCell(2).getNumericCellValue());
			summary.setCollection(row.getCell(3).getNumericCellValue());
			summary.setExpense(row.getCell(4).getNumericCellValue());
			summary.setClosingBalance(row.getCell(5).getNumericCellValue());
			monthlySummaryRepository.save(summary);
		}
		workbook.close();
	}
}