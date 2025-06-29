package com.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Leaves {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveId;
	private long employeeId;
	private boolean fd;
	private boolean hd;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public boolean isFd() {
		return fd;
	}
	public void setFd(boolean fd) {
		this.fd = fd;
	}
	public boolean isHd() {
		return hd;
	}
	public void setHd(boolean hd) {
		this.hd = hd;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}
