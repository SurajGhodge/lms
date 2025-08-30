package com.lms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.dto.LeaveRequestDto;
import com.lms.entity.Employee;
import com.lms.entity.Leaves;
import com.lms.repository.EmployeeRepo;
import com.lms.service.LeavesService;
import com.lms.service.LeavesServiceImpl;

@Controller
@RequestMapping("/api/leaves")
public class LeaveController1 {
	@Autowired
	private LeavesServiceImpl leavesServiceImpl;
	@Autowired
	private EmployeeRepo employeeRepo;

	// Show apply leave form
	@GetMapping("/apply")
	public String showApplyLeaveForm(Model model) {
		model.addAttribute("leaveRequest", new LeaveRequestDto());
		return "applyLeaveForm"; // thymeleaf page
	}

	// Handle Apply Leave form submission
	@PostMapping("/applyaction")
	public String applyLeave(@ModelAttribute("leaveRequest") LeaveRequestDto request, Model model,
			Principal principal) {
		try {
			// get logged-in user's email
			String email = principal.getName();

			// fetch employee from DB by email
			Employee emp = employeeRepo.findByEmail(email);
			if (emp == null) {
				throw new RuntimeException("Employee not found with email: " + email);
			}

			// now call service using employee id
			Leaves leave = leavesServiceImpl.applyLeave(emp.getId(), request);

			model.addAttribute("message", "Leave Applied Successfully! Status: " + leave.getStatus());
		} catch (Exception e) {
			model.addAttribute("message", "Error while applying leave: " + e.getMessage());
		}

		model.addAttribute("leaveRequest", new LeaveRequestDto()); // reset form
		return "applyLeaveForm";
	}

	@GetMapping("/history")
	public String viewLeaveHistory(Model model) {
		List<Leaves> leaves = leavesServiceImpl.getAllLeaves();
		model.addAttribute("leaves", leaves);
		return "viewLeaveHistory"; // thymeleaf page
	}

	// Delete leave
	@GetMapping("/delete/{id}")
	public String deleteLeave(@PathVariable Long id) {
		leavesServiceImpl.deleteLeave(id);
		return "redirect:/leaves/history";
	}

	// Load update form
	@GetMapping("/update/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Leaves leave = leavesServiceImpl.getLeaveById(id);
		model.addAttribute("leave", leave);
		return "updateLeaveForm"; // Thymeleaf template name
	}

	// Handle update
	@PostMapping("/update/{id}")
	public String updateLeave(@PathVariable("id") Long id, @ModelAttribute("leave") Leaves leave) {
		leavesServiceImpl.updateLeave(leave, id);
		return "redirect:/leaves/history";
	}

	@GetMapping("/leave-record")
	public String getAllLeaves(Model model) {
		List<Leaves> leaves = leavesServiceImpl.getAllLeaves();
		model.addAttribute("leaves", leaves);
		return "leave-record-admin";
	}

	// Approve Leave
	@PostMapping("/approve/{id}")
	public String approveLeave(@PathVariable("id") Long id) {
		leavesServiceImpl.approveLeave(id);
		return "redirect:/api/leaves/leave-record"; // FIXED
	}

	// Reject Leave
	@PostMapping("/reject/{id}")
	public String rejectLeave(@PathVariable("id") Long id) {
		leavesServiceImpl.rejectLeave(id);
		return "redirect:/api/leaves/leave-record"; // FIXED
	}

}
