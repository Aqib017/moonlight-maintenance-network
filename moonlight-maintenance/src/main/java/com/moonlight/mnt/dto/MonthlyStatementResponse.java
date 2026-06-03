package com.moonlight.mnt.dto;
import java.util.List;
import com.moonlight.mnt.entity.Expense;
import com.moonlight.mnt.entity.MaintenancePayment;

public class MonthlyStatementResponse {
	
	private String month;
	private Integer year;
	private Double totalCollection;
	private Double totalExpense;
	private Double balance;
	private List<MaintenancePayment> payments;
	private List<Expense> expenses;

	public MonthlyStatementResponse() {
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
	public List<MaintenancePayment> getPayments() {
		return payments;
	}
	public void setPayments(List<MaintenancePayment> payments) {
		this.payments = payments;
	}
	public List<Expense> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
}
