package com.lms.service;

import java.time.LocalDate;

public interface LeaveAllocationService {
    void allocateMonthlyLeaves(LocalDate currentDate);
}