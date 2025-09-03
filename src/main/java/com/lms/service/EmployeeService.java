package com.lms.service;

import java.util.List;

import com.lms.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	Employee updateEmployee(Long id, Employee updatedEmployee);

	void deleteEmployee(Long id);

	Employee getEmployeeById(Long id);

	List<Employee> getAllEmployees();

	public void removeSessionMessage();

}
