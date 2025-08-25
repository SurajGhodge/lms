package com.lms.dto;

import java.time.LocalDate;

public class LeaveResponceDto {
	private long leaveId;
	private long id;
	private boolean fd;
	private boolean hd;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private double days;
	private String status;
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public double getDays() {
		return days;
	}
	public void setDays(double days) {
		this.days = days;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
