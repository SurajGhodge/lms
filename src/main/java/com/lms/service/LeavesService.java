package com.lms.service;

import java.util.List;

import com.lms.entity.Leaves;

public interface LeavesService {
Leaves applyLeave(Leaves leave);
Leaves updateLeave(Leaves leave,Long leaveId);
void deleteLeave(Long leaveId);
Leaves getLeaveById(Long leaveId);
List<Leaves> getAllLeaves();

}
