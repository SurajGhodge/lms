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
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private EmployeeRepo employeeRepo;
	@GetMapping("/profile")
public String profile()
{
	return "adminprofile";
}
	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			Employee employee = employeeRepo.findByEmail(email);
			m.addAttribute("admin", employee);

		}
			 	
		    }
	@GetMapping("/manageemployee")
	public String manageEmployee()
	{
		return "manage-employee";
	}
	@GetMapping("/manageholiday")
	public String manageHoliday()
	{
		return "manage-holiday";
	}
	@GetMapping("/manageleaves")
	public String manageLeaves()
	{
		return "manage-leaves-admin";
	}
	@GetMapping("/editadminpassword")
	public String editAdminPassword()
	{
		return "change-admin-password";
	}
	@GetMapping("/editadminprofile")
	public String editAdminProfile()
	{
		return "edit-admin-profile";
	}
	@GetMapping("/viewemployees")
	public String viewEmployees()
	{
		return "employee-list";
	}
}
