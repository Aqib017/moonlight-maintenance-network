package com.moonlight.mnt.service;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.moonlight.mnt.entity.Collection;
@Service
public class ExcelExportService {

    @Autowired
    private CollectionService collectionService;

    public byte[] exportCollections() throws Exception {

        List<Collection> collections =
                collectionService.getAllCollections();

        XSSFWorkbook workbook =
                new XSSFWorkbook();

        XSSFSheet sheet =
                workbook.createSheet(
                        "Collections");

        Row header =
                sheet.createRow(0);

        header.createCell(0)
              .setCellValue("Flat");

        header.createCell(1)
              .setCellValue("Month");

        header.createCell(2)
              .setCellValue("Year");

        header.createCell(3)
              .setCellValue("Amount");

        int rowNum = 1;

        for (Collection c : collections) {

            Row row =
                    sheet.createRow(rowNum++);

            row.createCell(0)
               .setCellValue(
                   c.getFlatNumber());

            row.createCell(1)
               .setCellValue(
                   c.getMonth());

            row.createCell(2)
               .setCellValue(
                   c.getYear());

            row.createCell(3)
               .setCellValue(
                   c.getAmount());
        }

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        workbook.write(out);

        workbook.close();

        return out.toByteArray();
    }
}