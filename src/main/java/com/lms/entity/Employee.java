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

@Entity
@Table(name = "employees")
public class Employee {

    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
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
    private String employeeStatus;   // e.g., Active, Inactive

    @Column(name = "employment_type")
    private String employmentType;   // e.g., Full Time, Part Time, 6 Hrs

    private String branch;

    public List<Leaves> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<Leaves> leaves) {
		this.leaves = leaves;
	}

	@Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "reporting_authority")
    private String reportingAuthority;
    
    private double leaveBalance;
    @OneToMany(mappedBy = "employee")
    private List<Leaves> leaves = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getReportingAuthority() {
		return reportingAuthority;
	}

	public void setReportingAuthority(String reportingAuthority) {
		this.reportingAuthority = reportingAuthority;
	}

	public double getLeaveBalance() {
		return leaveBalance;
	}

	public void setLeaveBalance(double leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
	 public boolean isPermanent() {
	        return "Permanent".equalsIgnoreCase(this.employmentStatus);
	    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
   
    
}
