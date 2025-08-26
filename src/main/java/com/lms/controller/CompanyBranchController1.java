package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.entity.CompanyBranch;
import com.lms.entity.Employee;
import com.lms.repository.CompanyBranchRepository;
import com.lms.service.CompanyBranchServiceImpl;

@Controller
@RequestMapping("/branch")
public class CompanyBranchController1 {
	@Autowired
	private CompanyBranchServiceImpl companyBranchServiceImpl;
	@Autowired
	private CompanyBranchRepository companyBranchRepository;
	
	 @GetMapping("/list")
	    public String listEmployees(Model model) {
	        List<CompanyBranch> branch = companyBranchServiceImpl.allCompanyBranch();
	        model.addAttribute("branch", branch);
	        return "branch-list"; // 👉 corresponds to your Thymeleaf template name
	    }

}
