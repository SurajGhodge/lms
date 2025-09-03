package com.lms.repository;

import com.lms.entity.LeaveAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveAllocationRepository extends JpaRepository<LeaveAllocation, Long> {
}