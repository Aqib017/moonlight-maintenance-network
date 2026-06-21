package com.moonlight.mnt.dto;

public class DueReportDto {

    private String flatNumber;
    private Double expectedAmount;
    private Double paidAmount;
    private Double dueAmount;

	public DueReportDto(String flatNumber, Double expectedAmount, Double paidAmount, Double dueAmount) {
		this.flatNumber = flatNumber;
		this.expectedAmount = expectedAmount;
		this.paidAmount = paidAmount;
		this.dueAmount = dueAmount;
	}

    public String getFlatNumber() {
        return flatNumber;
    }
    public Double getExpectedAmount() {
        return expectedAmount;
    }
    public Double getPaidAmount() {
        return paidAmount;
    }
    public Double getDueAmount() {
        return dueAmount;
    }
}