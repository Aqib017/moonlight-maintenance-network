package com.moonlight.mnt.entity;
import java.time.LocalDate;
import com.moonlight.mnt.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
@Entity
@Table(name = "maintenance_payments")
public class MaintenancePayment {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		@Column(nullable = false)
		@NotBlank(message="Flat number is required")
	    private String flatNumber;
		
		@Column(nullable = false)
		@NotBlank(message="Month is required")
	    private String month;
		
		@Column(nullable = false)
		@NotNull(message="Year is required")
	    private Integer year;
		
		@Column(nullable = false)
		@NotNull(message="Amount is required")
		@Positive(message="Amount must be positive")
	    private Double amount;
		
	    @Enumerated(EnumType.STRING)
	    
	    @NotNull(message="PaymentStatus is required")
	    private PaymentStatus paymentStatus;
	    private LocalDate paymentDate;
	    private String remarks;
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFlatNumber() {
			return flatNumber;
		}
		public void setFlatNumber(String flatNumber) {
			this.flatNumber = flatNumber;
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
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public PaymentStatus getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(PaymentStatus paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public LocalDate getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(LocalDate paymentDate) {
			this.paymentDate = paymentDate;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		public MaintenancePayment() {
	    }
}
