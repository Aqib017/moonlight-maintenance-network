package com.moonlight.mnt.dto;
import java.util.List;
import com.moonlight.mnt.entity.MaintenancePayment;

public class ResidentSummaryResponse {
	
	private String flatNumber;
    private String ownerName;
    private String phoneNumber;
    private Double monthlyCharge;
    private Boolean active;
    private Long totalPayments;
    private Long duePayments;
    private Double outstandingAmount;
    private List<String> dueMonths;
    private List<MaintenancePayment> paymentHistory;

    public ResidentSummaryResponse() {
    }
    public String getFlatNumber() {
        return flatNumber;
    }
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Double getMonthlyCharge() {
		return monthlyCharge;
	}
	public void setMonthlyCharge(Double monthlyCharge) {
		this.monthlyCharge = monthlyCharge;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<MaintenancePayment> getPaymentHistory() {
		return paymentHistory;
	}
	public void setPaymentHistory(List<MaintenancePayment> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}
	public Long getTotalPayments() {
		return totalPayments;
	}
	public void setTotalPayments(Long totalPayments) {
		this.totalPayments = totalPayments;
	}
	public Long getDuePayments() {
		return duePayments;
	}
	public void setDuePayments(Long duePayments) {
		this.duePayments = duePayments;
	}
	public Double getOutstandingAmount() {
		return outstandingAmount;
	}
	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
	public List<String> getDueMonths() {
		return dueMonths;
	}
	public void setDueMonths(List<String> dueMonths) {
		this.dueMonths = dueMonths;
	}

}
