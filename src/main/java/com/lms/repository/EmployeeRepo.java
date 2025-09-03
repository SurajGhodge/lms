package com.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	Employee findByEmail(String email);

	Optional<Employee> findByNameContainingIgnoreCase(String name);
}
