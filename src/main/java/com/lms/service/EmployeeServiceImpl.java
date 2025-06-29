package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Employee;
import com.lms.exception.EmployeeNotFoundException;
import com.lms.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
EmployeeRepo employeeRepo;
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		return employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		 Optional<Employee> existingEmployeeOpt = employeeRepo.findById(id);
	        if (existingEmployeeOpt.isPresent()) {
	            Employee existingEmployee = existingEmployeeOpt.get();
	            // update fields
	            existingEmployee.setName(updatedEmployee.getName());
	            existingEmployee.setEmployeeId(updatedEmployee.getEmployeeId());
	            existingEmployee.setPermanentAddress(updatedEmployee.getPermanentAddress());
	            existingEmployee.setCurrentAddress(updatedEmployee.getCurrentAddress());
	            existingEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
	            existingEmployee.setEmergencyContact(updatedEmployee.getEmergencyContact());
	            existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
	            existingEmployee.setDateOfJoining(updatedEmployee.getDateOfJoining());
	            existingEmployee.setEmploymentStatus(updatedEmployee.getEmploymentStatus());
	            existingEmployee.setEmployeeStatus(updatedEmployee.getEmployeeStatus());
	            existingEmployee.setEmploymentType(updatedEmployee.getEmploymentType());
	            existingEmployee.setBranch(updatedEmployee.getBranch());
	            existingEmployee.setBloodGroup(updatedEmployee.getBloodGroup());
	            existingEmployee.setReportingAuthority(updatedEmployee.getReportingAuthority());

	            return employeeRepo.save(existingEmployee);
	        } else {
	            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
	        }
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		if (!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepo.deleteById(id);
    
	}

	@Override
	public Employee getEmployeeById(Long id) {
		 return employeeRepo.findById(id)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
	}

	@Override
	public List<Employee> getAllEmployees() {
		 return employeeRepo.findAll();
	}

}
