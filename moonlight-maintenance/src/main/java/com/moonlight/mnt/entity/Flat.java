package com.moonlight.mnt.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="flats")
public class Flat {
	public Flat() {
		super();
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String flatNumber;
	
	private String ownerName;
	
	@Column(nullable = false)
    private String flatType;
	
    @Column(nullable = false)
    private Double monthlyCharge;
    
    private String phoneNumber;
    private Boolean active;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlatNumber() {
		return flatNumber;
	}
	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Double getMonthlyCharge() {
		return monthlyCharge;
	}
	public void setMonthlyCharge(Double monthlyCharge) {
		this.monthlyCharge = monthlyCharge;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	} 

}
