package com.lms.util;

import com.lms.dto.LeaveRequestDto;
import com.lms.dto.LeaveResponceDto;
import com.lms.entity.Leaves;

public class LeaveMapper {
public static Leaves toEntity(LeaveRequestDto dto)
{
	Leaves leaves=new Leaves();
	leaves.setEmployeeId(dto.getEmployeeId());
	leaves.setFd(dto.isFd());
	leaves.setFromDate(dto.getFromDate());
	leaves.setHd(dto.isHd());
	leaves.setLeaveId(dto.getLeaveId());
	leaves.setReason(dto.getReason());
	leaves.setToDate(dto.getToDate());
	return leaves;
}
public static LeaveResponceDto toResponceDto(Leaves leave)
{	LeaveResponceDto leaveResponceDto=new LeaveResponceDto();
leaveResponceDto.setEmployeeId(leave.getEmployeeId());
leaveResponceDto.setFd(leave.isFd());
leaveResponceDto.setFromDate(leave.getFromDate());
leaveResponceDto.setHd(leave.isHd());
leaveResponceDto.setLeaveId(leave.getLeaveId());
leaveResponceDto.setReason(leave.getReason());
leaveResponceDto.setToDate(leave.getToDate());
	return leaveResponceDto;
}
}
