package com.lms.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dto.LeaveRequestDto;
import com.lms.entity.Employee;
import com.lms.entity.Leaves;
import com.lms.exception.LeaveNotFoundException;
import com.lms.repository.EmployeeRepo;
import com.lms.repository.LeavesRepository;
@Service
public class LeavesServiceImpl implements LeavesService {
	@Autowired
	LeavesRepository leavesRepository;
	@Autowired
	EmployeeRepo employeeRepo;
	@Override
    public Leaves applyLeave(Long id, LeaveRequestDto request) {
        Employee emp = employeeRepo.findById(id).orElseThrow();
        int leaveDays = (int) ChronoUnit.DAYS.between(request.getFromDate(), request.getToDate()) + 1;

        Leaves leave = new Leaves();
        leave.setEmployee(emp);
        leave.setFromDate(request.getFromDate());
        leave.setToDate(request.getToDate());
        leave.setDays(leaveDays);
        leave.setStatus("PENDING");
        leave.setReason(request.getReason());
        emp.setLeaveBalance(emp.getLeaveBalance() - leaveDays);
        employeeRepo.save(emp);
        return leavesRepository.save(leave);
    }

	@Override
	public Leaves updateLeave(Leaves updatedleave,Long leaveId) {
	Optional<Leaves> existingLeaveOpt=leavesRepository.findById(leaveId);
	if(existingLeaveOpt.isPresent())
	{
		Leaves existingLeave=existingLeaveOpt.get();
		existingLeave.setEmployee(updatedleave.getEmployee());
		existingLeave.setHd(updatedleave.isHd());
		existingLeave.setFd(updatedleave.isFd());
		//existingLeave.setLeaveId(updatedleave.getLeaveId());
		existingLeave.setReason(updatedleave.getReason());
		existingLeave.setToDate(updatedleave.getToDate());
		existingLeave.setFromDate(updatedleave.getFromDate());
		leavesRepository.save(existingLeave);
		return existingLeave;
		
	}
		
		return null;
	}

	@Override
	public void deleteLeave(Long leaveId) {
		if(!leavesRepository.existsById(leaveId))
		{
			throw new LeaveNotFoundException("Leave Not Found with id " + leaveId);
		}
		leavesRepository.deleteById(leaveId);
		
	}

	@Override
	public Leaves getLeaveById(Long leaveId) {
	    return leavesRepository.findById(leaveId)
	        .orElseThrow(() -> new LeaveNotFoundException("Leave Not Found with id " + leaveId));
	}

	@Override
	public List<Leaves> getAllLeaves() {
		// TODO Auto-generated method stub
		return leavesRepository.findAll();
	}

	@Override
	public void cancelLeave(Long leaveId) {
		Leaves leave=leavesRepository.findById(leaveId).orElseThrow(()->new LeaveNotFoundException("Leave not found"));
		if((leave.getStatus().equals("APPROVED") || leave.getStatus().equals("PENDING")))
		{
			Employee emp=leave.getEmployee();
			emp.setLeaveBalance(emp.getLeaveBalance()+leave.getDays());
			leave.setStatus("CANCELLED");
			leavesRepository.save(leave);
			employeeRepo.save(emp);
		}
		
	}

	@Override
	public void approveLeave(Long leaveId) {
		// TODO Auto-generated method stub
		Leaves leave=leavesRepository.findById(leaveId).orElseThrow(()->new LeaveNotFoundException("Leave Not found"));
		leave.setStatus("APPROVED");
		leavesRepository.save(leave);
		
	}

	@Override
	public void rejectLeave(Long leaveId) {
		// TODO Auto-generated method stub
		Leaves leave=leavesRepository.findById(leaveId).orElseThrow(()-> new LeaveNotFoundException("Leave not found"));
		leave.setStatus("REJECTED");
		Employee emp=leave.getEmployee();
		emp.setLeaveBalance(emp.getLeaveBalance()+leave.getDays());
		leavesRepository.save(leave);
		employeeRepo.save(emp);
		
	}

	@Override
	public Long getEmployeeIdByEmail(String email) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepo.findByEmail(email);
		return employee.getId();
	}

}
