package com.lms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	Employee findByEmail(String email);
}
