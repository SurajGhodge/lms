package com.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int leaveTypeId;
private String leaveTypeName;
public int getLeaveTypeId() {
	return leaveTypeId;
}
public void setLeaveTypeId(int leaveTypeId) {
	this.leaveTypeId = leaveTypeId;
}
public String getLeaveTypeName() {
	return leaveTypeName;
}
public void setLeaveTypeName(String leaveTypeName) {
	this.leaveTypeName = leaveTypeName;
}

}
