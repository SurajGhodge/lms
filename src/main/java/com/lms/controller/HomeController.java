package com.lms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lms.entity.Employee;
import com.lms.repository.EmployeeRepo;
import com.lms.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeRepo employeeRepo;
    @GetMapping("/")
    public String home() {
        return "index";   // loads index.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";   // loads about.html
    }

//    @GetMapping("/profile")
//    public String profile(Principal p, Model m) {
//        String email = p.getName();
//        Employee employee = employeeRepo.findByEmail(email);
//        m.addAttribute("employee", employee);
//        return "profile";
//    }

    @GetMapping("/signin")
    public String login() {
        return "login";   // loads login.html
    }
    @GetMapping("/register")
    public String register()
    {
    	return "register";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee,HttpSession session)
    {
    	Employee employeeSave=employeeService.saveEmployee(employee);
    	if(employeeSave!=null)
    	{
    		session.setAttribute("msg", "You have register successfully........");
    		System.out.println("employee saved");
    	}
    	else
    	{
    		session.setAttribute("msg", "Something went wrong........");
    		System.out.println("not save");
    	}
    	return "redirect:/register";
    }
}
