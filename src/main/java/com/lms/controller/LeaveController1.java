package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.dto.LeaveRequestDto;
import com.lms.service.LeavesService;

@Controller
@RequestMapping("/leaves")
public class LeaveController1 {
	 @Autowired
	    private LeavesService leaveService;

	    // Show apply leave form
	    @GetMapping("/apply")
	    public String showApplyLeaveForm(Model model) {
	        model.addAttribute("leaveRequest", new LeaveRequestDto());
	        return "applyLeave"; // thymeleaf page
	    }
}
