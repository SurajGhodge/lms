package com.lms.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.employee.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
