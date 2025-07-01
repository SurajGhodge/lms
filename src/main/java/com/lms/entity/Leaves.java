package com.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Leaves {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveId;
	private boolean fd;
	private boolean hd;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private String status;//approved/rejected/cancelled/pending
	private int days;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
