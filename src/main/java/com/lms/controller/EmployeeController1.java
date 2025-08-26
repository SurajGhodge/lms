package com.lms.controller;

import com.lms.entity.Employee;
import com.lms.exception.EmployeeNotFoundException;
import com.lms.repository.EmployeeRepo;
import com.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController1 {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;

    // ✅ Get all employees
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list"; // 👉 corresponds to your Thymeleaf template name
    }

    // ✅ Show add employee form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form"; // 👉 Create employee-form.html
    }

    // ✅ Save new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update-employee"; // this will load update-employee.html
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee updatedEmployee) {
        employeeService.updateEmployee(id, updatedEmployee);
        return "redirect:/employee/list"; // redirect back to employee list
    }

    // ✅ Delete employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

    // ✅ View employee details (optional)
    @GetMapping("/{id}")
    public String viewEmployee(@PathVariable Long id, Model model) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            model.addAttribute("employee", employee);
            return "one-employee-view"; // 👉 Create employee-details.html if needed
        } catch (EmployeeNotFoundException e) {
            return "redirect:/employee/list";
        }
    }
    @GetMapping("/search")
    public String searchEmployee(@RequestParam("keyword") String keyword, Model model) {
        Employee employee = employeeRepo
                .findByNameContainingIgnoreCase(keyword)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        model.addAttribute("employee", employee);
        return "one-employee-view"; // show in details page
    }
}
