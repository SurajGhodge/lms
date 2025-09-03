package com.lms.service;

import java.util.List;

import com.lms.entity.LeaveType;

public interface LeaveTypeService {
	public LeaveType add(LeaveType leaveType);

	public LeaveType update(LeaveType leaveType, int leaveTypeId);

	public List<LeaveType> getAll();

	public void deleteLeaveType(int leaveTypeId);

	LeaveType getById(int id);
}
