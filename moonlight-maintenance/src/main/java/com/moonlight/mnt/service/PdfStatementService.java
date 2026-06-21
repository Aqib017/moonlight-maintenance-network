package com.moonlight.mnt.service;
import java.io.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.moonlight.mnt.dto.MonthlyStatementResponse;
@Service
public class PdfStatementService {

    @Autowired
    private MonthlyStatementService monthlyStatementService;

    public byte[] generatePdf(
            String month,
            Integer year) throws Exception {

        MonthlyStatementResponse statement =
                monthlyStatementService
                .getMonthlyStatement(month, year);

        Document document =
                new Document();

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);

        document.open();

        document.add(
                new Paragraph(
                        "Moonlight Apartment"));
        
        document.add(
                new Paragraph(
                        "Monthly Statement"));

        document.add(
                new Paragraph(
                        "Month: " + month));

        document.add(
                new Paragraph(
                        "Year: " + year));

        document.add(
                new Paragraph(
                        " "));

        document.add(
                new Paragraph(
                        "Collection: ₹"
                        + statement.getTotalCollection()));

        document.add(
                new Paragraph(
                        "Expense: ₹"
                        + statement.getTotalExpense()));

        document.add(
                new Paragraph(
                        "Balance: ₹"
                        + statement.getBalance()));

        document.close();

        return out.toByteArray();
    }
}