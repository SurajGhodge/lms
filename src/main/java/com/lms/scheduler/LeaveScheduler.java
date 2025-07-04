package com.lms.scheduler;

import com.lms.service.LeaveAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class LeaveScheduler {

    @Autowired
    private LeaveAllocationService leaveAllocationService;

    @Scheduled(cron = "0 0 1 1 * ?") // 1 AM on 1st of every month
    public void runMonthlyLeaveAllocation() {
        leaveAllocationService.allocateMonthlyLeaves(LocalDate.now());
    }
}
