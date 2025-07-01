package com.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompanyBranch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int baranchId;
	private String address;
	private String contactNumber;
	private String email;
	public int getBaranchId() {
		return baranchId;
	}
	public void setBaranchId(int baranchId) {
		this.baranchId = baranchId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
