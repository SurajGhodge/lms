package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.LeaveType;
import com.lms.repository.LeaveTypeRepository;
@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;
	@Override
	public LeaveType add(LeaveType leaveType) {
		// TODO Auto-generated method stub
		return leaveTypeRepository.save(leaveType);
	}

	@Override
	public LeaveType update(LeaveType leaveType, int leaveTypeId) {
		
		Optional<LeaveType> leaveTypeExist=leaveTypeRepository.findById(leaveTypeId);
		if(leaveTypeExist.isPresent())
		{
			LeaveType leaveTypeUpdated=leaveTypeExist.get();
			leaveTypeUpdated.setLeaveTypeName(leaveType.getLeaveTypeName());
			return leaveTypeRepository.save(leaveTypeUpdated);
		}
		return null;
	}

	@Override
	public List<LeaveType> getAll() {
	    return leaveTypeRepository.findAll(); // This usually returns empty list, never null
	}

	@Override
	public void deleteLeaveType(int leaveTypeId) {
		Optional<LeaveType> leaveTypeExist=leaveTypeRepository.findById(leaveTypeId);
		if(leaveTypeExist.isPresent())
		{
			LeaveType leaveType=leaveTypeExist.get();
			leaveTypeRepository.delete(leaveType);
		}
		
		
	}

	@Override
	public LeaveType getById(int id) {
	    return leaveTypeRepository.findById(id).orElse(null);
	}

}
