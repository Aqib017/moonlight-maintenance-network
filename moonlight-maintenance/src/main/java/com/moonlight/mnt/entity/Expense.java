package com.moonlight.mnt.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "expenses")
public class Expense {
	    @Id
	    @GeneratedValue(strategy =GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false)
	    private String expenseName;
	    
	    @Column(nullable = false)
	    private Double amount;
	    
	    @Column(nullable = false)
	    private String month;
	    
	    @Column(nullable = false)
	    private Integer year;
	    private LocalDate expenseDate;
	    private String remarks;
		public Expense() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getExpenseName() {
			return expenseName;
		}
		public void setExpenseName(String expenseName) {
			this.expenseName = expenseName;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
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
		public LocalDate getExpenseDate() {
			return expenseDate;
		}
		public void setExpenseDate(LocalDate expenseDate) {
			this.expenseDate = expenseDate;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

}
