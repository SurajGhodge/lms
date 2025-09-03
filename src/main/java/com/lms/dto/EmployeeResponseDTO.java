package com.lms.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeResponseDTO {
	private Long id;
	private String name;
	private String permanentAddress;
	private String currentAddress;
	private String mobileNumber;
	private String emergencyContact;
	private LocalDate dateOfBirth;
	private LocalDate dateOfJoining;
	private String employmentStatus;
	private String employeeStatus;
	private String employmentType;
	private String branch;
	private String bloodGroup;
	private String reportingAuthority;
	private double leaveBalance;
	private String email;
	private String password;
	private String role;

}