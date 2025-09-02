package com.lms.controller;
import com.lms.repository.LeaveAllocationRepository;
import com.lms.service.LeaveAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/leaves")
public class LeaveAllocationController {

    @Autowired
    private LeaveAllocationService leaveAllocationService;
    @Autowired
    private LeaveAllocationRepository leaveAllocationRepository;
    @GetMapping("/leave-credit")
    public String creditLeavesManually(Model model) {
        // Call the same service logic that scheduler uses
        leaveAllocationService.allocateMonthlyLeaves(LocalDate.now());
        model.addAttribute("records", leaveAllocationRepository.findAll());
        return "leaveAllocationRecords"; // thymeleaf page
    }
   
}
