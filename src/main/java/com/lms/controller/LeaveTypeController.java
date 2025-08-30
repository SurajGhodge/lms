package com.lms.controller;

import com.lms.entity.LeaveType;
import com.lms.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/leave-types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    // List all leave types
    @GetMapping
    public String listLeaveTypes(Model model) {
        List<LeaveType> leaveTypes = leaveTypeService.getAll();
        model.addAttribute("leaveTypes", leaveTypes);
        return "leave-type-list";
    }

    // Show add form
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("leaveType", new LeaveType());
        return "leave-type-add"; // separate add form
    }

    // Handle add form submit
    @PostMapping("/add")
    public String saveLeaveType(@ModelAttribute("leaveType") LeaveType leaveType) {
        leaveTypeService.add(leaveType);
        return "redirect:/leave-types";
    }

    // Show update form
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        LeaveType leaveType = leaveTypeService.getById(id);
        model.addAttribute("leaveType", leaveType);
        return "leave-type-edit"; // separate update form
    }

    // Handle update form submit
    @PostMapping("/update/{id}")
    public String updateLeaveType(@PathVariable("id") int id,
                                  @ModelAttribute("leaveType") LeaveType leaveType) {
        leaveTypeService.update(leaveType, id);
        return "redirect:/leave-types";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteLeaveType(@PathVariable("id") int id) {
        leaveTypeService.deleteLeaveType(id);
        return "redirect:/leave-types";
    }

    // View details
    @GetMapping("/{id}")
    public String viewLeaveType(@PathVariable("id") int id, Model model) {
        LeaveType leaveType = leaveTypeService.getById(id);
        model.addAttribute("leaveType", leaveType);
        return "leave-type-view";
    }
}
