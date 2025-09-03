package com.lms.util;

import com.lms.dto.EmployeeRequestDTO;
import com.lms.dto.EmployeeResponseDTO;
import com.lms.entity.Employee;

public class EmployeeMapper {

	public static Employee toEntity(EmployeeRequestDTO dto) {
		Employee emp = new Employee();
		emp.setId(dto.getId());
		emp.setName(dto.getName());
		emp.setPermanentAddress(dto.getPermanentAddress());
		emp.setCurrentAddress(dto.getCurrentAddress());
		emp.setMobileNumber(dto.getMobileNumber());
		emp.setEmergencyContact(dto.getEmergencyContact());
		emp.setDateOfBirth(dto.getDateOfBirth());
		emp.setDateOfJoining(dto.getDateOfJoining());
		emp.setEmploymentStatus(dto.getEmploymentStatus());
		emp.setEmployeeStatus(dto.getEmployeeStatus());
		emp.setEmploymentType(dto.getEmploymentType());
		emp.setBranch(dto.getBranch());
		emp.setBloodGroup(dto.getBloodGroup());
		emp.setReportingAuthority(dto.getReportingAuthority());
		emp.setLeaveBalance(dto.getLeaveBalance());
		emp.setEmail(dto.getEmail());
		emp.setPassword(dto.getPassword());
		emp.setRole(dto.getRole());
		return emp;
	}

	public static EmployeeResponseDTO toResponseDTO(Employee employee) {
		EmployeeResponseDTO dto = new EmployeeResponseDTO();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setMobileNumber(employee.getMobileNumber());
		dto.setBranch(employee.getBranch());
		dto.setDateOfJoining(employee.getDateOfJoining());
		dto.setBloodGroup(employee.getBloodGroup());
		dto.setCurrentAddress(employee.getCurrentAddress());
		dto.setDateOfBirth(employee.getDateOfBirth());
		dto.setEmergencyContact(employee.getEmergencyContact());
		dto.setEmployeeStatus(employee.getEmployeeStatus());
		dto.setEmploymentStatus(employee.getEmploymentStatus());
		dto.setEmploymentType(employee.getEmploymentType());
		dto.setPermanentAddress(employee.getPermanentAddress());
		dto.setReportingAuthority(employee.getReportingAuthority());
		dto.setLeaveBalance(employee.getLeaveBalance());
		dto.setEmail(employee.getEmail());
		dto.setPassword(employee.getPassword());
		dto.setRole(employee.getRole());
		return dto;
	}
}
