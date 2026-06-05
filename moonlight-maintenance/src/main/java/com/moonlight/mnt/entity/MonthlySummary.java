package com.moonlight.mnt.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "monthly_summary")
public class MonthlySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String month;
    private Integer year;
    private Double openingBalance;
    private Double collection;
    private Double expense;
    private Double closingBalance;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Double getOpeningBalance() {
        return openingBalance;
    }
    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }
    public Double getCollection() {
        return collection;
    }
    public void setCollection(Double collection) {
        this.collection = collection;
    }
    public Double getExpense() {
        return expense;
    }
    public void setExpense(Double expense) {
        this.expense = expense;
    }
    public Double getClosingBalance() {
        return closingBalance;
    }
    public void setClosingBalance(Double closingBalance) {
        this.closingBalance = closingBalance;
    }
}