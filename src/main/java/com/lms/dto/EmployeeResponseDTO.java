package com.lms.dto;

import java.time.LocalDate;

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
	    private int leaveBalance;
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
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public int getLeaveBalance() {
			return leaveBalance;
		}
		public void setLeaveBalance(int leaveBalance) {
			this.leaveBalance = leaveBalance;
		}
		
	    
}