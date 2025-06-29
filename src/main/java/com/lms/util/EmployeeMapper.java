package com.lms.util;
import com.lms.dto.EmployeeRequestDTO;
import com.lms.dto.EmployeeResponseDTO;
import com.lms.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequestDTO dto) {
        Employee emp = new Employee();
        emp.setEmployeeId(dto.getEmployeeId());
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
        return emp;
    }

    public static EmployeeResponseDTO toResponseDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setName(employee.getName());
        dto.setMobileNumber(employee.getMobileNumber());
        dto.setBranch(employee.getBranch());
        dto.setDateOfJoining(employee.getDateOfJoining());
        return dto;
    }
}
