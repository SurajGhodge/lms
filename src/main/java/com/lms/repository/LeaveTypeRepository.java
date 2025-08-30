package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {

}
