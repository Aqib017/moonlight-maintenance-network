package com.moonlight.mnt.dto;

public class DashboardSummaryResponse {
	
	private String month;
    private Integer year;
    private Long totalFlats;
    private Long duePayments;
    private Double totalCollection;
    private Double totalExpense;
    private Double balance;
    private Long totalCollectionsRecorded;

    public Long getTotalCollectionsRecorded() {
        return totalCollectionsRecorded;
    }
	public void setTotalCollectionsRecorded(Long totalCollectionsRecorded) {
		this.totalCollectionsRecorded = totalCollectionsRecorded;
	}
    public DashboardSummaryResponse() {
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
    public Long getTotalFlats() {
        return totalFlats;
    }
    public void setTotalFlats(Long totalFlats) {
        this.totalFlats = totalFlats;
    }
    public Long getDuePayments() {
        return duePayments;
    }
    public void setDuePayments(Long duePayments) {
        this.duePayments = duePayments;
    }
    public Double getTotalCollection() {
        return totalCollection;
    }
    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
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
        this.balance = balance;
    }
}
