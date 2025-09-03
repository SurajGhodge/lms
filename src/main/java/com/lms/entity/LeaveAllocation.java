package com.lms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.YearMonth;
@Entity
@Data
public class LeaveAllocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	private String leaveType; // e.g., "PL"
	private int leaveCount;
	private YearMonth allocationMonth;

}