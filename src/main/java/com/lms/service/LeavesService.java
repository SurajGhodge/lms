package com.lms.service;

import java.util.List;

import com.lms.dto.LeaveRequestDto;
import com.lms.entity.Leaves;

public interface LeavesService {
Leaves applyLeave(Long employeeId, LeaveRequestDto request);
Leaves updateLeave(Leaves leave,Long leaveId);
void deleteLeave(Long leaveId);
Leaves getLeaveById(Long leaveId);
List<Leaves> getAllLeaves();  
void cancelLeave(Long leaveId);
void approveLeave(Long leaveId);
void rejectLeave(Long leaveId);

Long getEmployeeIdByEmail(String email);


}
