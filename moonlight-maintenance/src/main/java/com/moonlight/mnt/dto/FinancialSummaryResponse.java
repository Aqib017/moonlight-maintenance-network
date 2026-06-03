package com.moonlight.mnt.dto;

public class FinancialSummaryResponse {

	    private String month;
	    private Integer year;
	    private Double totalCollection;
	    private Double totalExpense;
	    private Double balance;

	    public FinancialSummaryResponse() {
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
	    public Double getTotalCollection() {
	        return totalCollection;
	    }
	    public void setTotalCollection(Double totalCollection) {
	        this.totalCollection =totalCollection;
	    }
	    public Double getTotalExpense() {
	        return totalExpense;
	    }
	    public void setTotalExpense(Double totalExpense) {
	        this.totalExpense = totalExpense;
	    }
	    public Double getBalance() {
	        return balance;
	    }
	    public void setBalance(Double balance) {
	        this.balance =balance;
	    }
	}
