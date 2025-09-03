package com.lms.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String role;
	@Column(name = "permanent_address")
	private String permanentAddress;
	@Column(name = "current_address")
	private String currentAddress;
	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "emergency_contact")
	private String emergencyContact;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;

	@Column(name = "employment_status")
	private String employmentStatus; // e.g., Permanent, Probation, Consultant

	@Column(name = "employee_status")
	private String employeeStatus; // e.g., Active, Inactive

	@Column(name = "employment_type")
	private String employmentType; // e.g., Full Time, Part Time, 6 Hrs

	private String branch;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "reporting_authority")
	private String reportingAuthority;

	private double leaveBalance;
	@OneToMany(mappedBy = "employee")
	private List<Leaves> leaves = new ArrayList<>();

	public boolean isPermanent() {
		return "Permanent".equalsIgnoreCase(this.employmentStatus);
	}

}
