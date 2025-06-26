package com.lms.employee.service;

import java.util.List;

import com.lms.employee.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
}
