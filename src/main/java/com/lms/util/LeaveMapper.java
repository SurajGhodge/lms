package com.lms.util;

import com.lms.dto.LeaveRequestDto;
import com.lms.dto.LeaveResponceDto;
import com.lms.entity.Employee;
import com.lms.entity.Leaves;

public class LeaveMapper {

	public static Leaves toEntity(LeaveRequestDto dto, Employee employee) {
		Leaves leaves = new Leaves();
		leaves.setEmployee(employee);
		leaves.setFd(dto.isFd());
		leaves.setFromDate(dto.getFromDate());
		leaves.setHd(dto.isHd());
		leaves.setLeaveId(dto.getLeaveId());
		leaves.setReason(dto.getReason());
		leaves.setToDate(dto.getToDate());
		return leaves;
	}

	public static LeaveResponceDto toResponceDto(Leaves leave) {
		LeaveResponceDto leaveResponseDto = new LeaveResponceDto();
		leaveResponseDto.setId(leave.getEmployee().getId());
		leaveResponseDto.setFd(leave.isFd());
		leaveResponseDto.setFromDate(leave.getFromDate());
		leaveResponseDto.setHd(leave.isHd());
		leaveResponseDto.setLeaveId(leave.getLeaveId());
		leaveResponseDto.setReason(leave.getReason());
		leaveResponseDto.setToDate(leave.getToDate());
		return leaveResponseDto;
	}
}
