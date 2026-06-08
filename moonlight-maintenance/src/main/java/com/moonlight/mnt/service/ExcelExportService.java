package com.moonlight.mnt.service;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.entity.Collection;
import com.moonlight.mnt.entity.Expense;
@Service
public class ExcelExportService {

    @Autowired
    private CollectionService collectionService;
    
    @Autowired
    private ExpenseService expenseService;

	public byte[] exportCollections() throws Exception {
		List<Collection> collections = collectionService.getAllCollections();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Collections");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Flat");
		header.createCell(1).setCellValue("Month");
		header.createCell(2).setCellValue("Year");
		header.createCell(3).setCellValue("Amount");
		int rowNum = 1;
		for (Collection c : collections) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(c.getFlatNumber());
			row.createCell(1).setCellValue(c.getMonth());
			row.createCell(2).setCellValue(c.getYear());
			row.createCell(3).setCellValue(c.getAmount());
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		workbook.close();
		return out.toByteArray();
	}

	public byte[] exportExpenses() throws Exception {

		List<Expense> expenses = expenseService.getAllExpenses();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Expenses");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Expense Name");
		header.createCell(1).setCellValue("Amount");
		header.createCell(2).setCellValue("Month");
		header.createCell(3).setCellValue("Year");
		int rowNum = 1;
		for (Expense e : expenses) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getExpenseName());
			row.createCell(1).setCellValue(e.getAmount());
			row.createCell(2).setCellValue(e.getMonth());
			row.createCell(3).setCellValue(e.getYear());
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		workbook.write(out);
		workbook.close();
		return out.toByteArray();
	}
}