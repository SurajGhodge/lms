package com.lms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.entity.Employee;
import com.lms.repository.EmployeeRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private EmployeeRepo employeeRepo;
	@GetMapping("/profile")
public String profile()
{
	return "user_profile";
}
	@GetMapping("/manageLeave")
	public String manageLeave()
	{
		return "manageLeave";
	}
	
	@GetMapping("/viewLeaveHistory")
	public String viewLeaveHistory()
	{
		return "viewLeaveHistory";
	}
	
	
	
	@GetMapping("/applyLeaveForm")
	public String applyLeaveForm()
	{
		return "applyLeaveForm";
	}
	

	@GetMapping("/holidayList")
	public String holidayList()
	{
		return "holidayList";
	}
	
@ModelAttribute
public void commonUser(Principal p, Model m) {
	if (p != null) {
		String email = p.getName();
		Employee employee = employeeRepo.findByEmail(email);
		m.addAttribute("employee", employee);

	}
		 	
	    }
}
