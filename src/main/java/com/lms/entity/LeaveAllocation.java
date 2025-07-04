package com.lms.entity;

import jakarta.persistence.*;
import java.time.YearMonth;

@Entity
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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public int getLeaveCount() { return leaveCount; }
    public void setLeaveCount(int leaveCount) { this.leaveCount = leaveCount; }

    public YearMonth getAllocationMonth() { return allocationMonth; }
    public void setAllocationMonth(YearMonth allocationMonth) { this.allocationMonth = allocationMonth; }
}