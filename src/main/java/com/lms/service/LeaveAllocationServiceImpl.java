package com.lms.service;

import com.lms.entity.Employee;
import com.lms.entity.LeaveAllocation;
import com.lms.repository.EmployeeRepo;

import com.lms.repository.LeaveAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class LeaveAllocationServiceImpl implements LeaveAllocationService {

    @Autowired
    private EmployeeRepo employeeRepository;

    @Autowired
    private LeaveAllocationRepository leaveAllocationRepository;

    public void allocateMonthlyLeaves(LocalDate currentDate) {
        YearMonth currentYearMonth = YearMonth.from(currentDate);
        LocalDate firstDayOfMonth = currentYearMonth.atDay(1);

        List<Employee> allEmployees = employeeRepository.findAll();

        for (Employee employee : allEmployees) {
            if (employee.isPermanent()) {
                LocalDate joiningDate = employee.getDateOfJoining();

                // Allocate for existing employees
                if (joiningDate.isBefore(firstDayOfMonth.minusMonths(1))) {
                    allocateLeave(employee, 2, currentDate);
                }

                // Allocate for employees who joined last month
                else if (YearMonth.from(joiningDate).equals(currentYearMonth.minusMonths(1))) {
                    int joiningDay = joiningDate.getDayOfMonth();
                    if (joiningDay < 15) {
                        allocateLeave(employee, 2, currentDate);
                    } else {
                        allocateLeave(employee, 1, currentDate);
                    }
                }
            }
        }
    }

    private void allocateLeave(Employee employee, int leaveCount, LocalDate allocationDate) {
        LeaveAllocation allocation = new LeaveAllocation();
        allocation.setEmployee(employee);
        allocation.setLeaveType("PL");
        allocation.setLeaveCount(leaveCount);
        allocation.setAllocationMonth(YearMonth.from(allocationDate));
        leaveAllocationRepository.save(allocation);
        
        int updatedBalance = employee.getLeaveBalance() + leaveCount;
        employee.setLeaveBalance(updatedBalance);
        employeeRepository.save(employee);
    }
}