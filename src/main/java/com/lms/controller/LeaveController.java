package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Leaves;
import com.lms.service.LeavesServiceImpl;
@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
	  @Autowired
	    private LeavesServiceImpl leavesServiceImpl;

	    // Apply for leave
	    @PostMapping("/apply")
	    public ResponseEntity<Leaves> applyLeave(@RequestBody Leaves leave) {
	        Leaves savedLeave = leavesServiceImpl.applyLeave(leave);
	        return ResponseEntity.ok(savedLeave);
	    }

	    // Update leave
	    @PutMapping("/{leaveId}")
	    public ResponseEntity<Leaves> updateLeave(@RequestBody Leaves updatedLeave, @PathVariable Long leaveId) {
	        Leaves leave = leavesServiceImpl.updateLeave(updatedLeave, leaveId);
	        if (leave == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(leave);
	    }

	    // Delete leave
	    @DeleteMapping("/{leaveId}")
	    public ResponseEntity<Void> deleteLeave(@PathVariable Long leaveId) {
	        leavesServiceImpl.deleteLeave(leaveId);
	        return ResponseEntity.noContent().build();
	    }

	    // Get leave by ID
	    @GetMapping("/{leaveId}")
	    public ResponseEntity<Leaves> getLeaveById(@PathVariable Long leaveId) {
	        Leaves leave = leavesServiceImpl.getLeaveById(leaveId);
	        return ResponseEntity.ok(leave);
	    }

	    // Get all leaves
	    @GetMapping("/allleaves")
	    public ResponseEntity<List<Leaves>> getAllLeaves() {
	        List<Leaves> leaves = leavesServiceImpl.getAllLeaves();
	        return ResponseEntity.ok(leaves);
	    }
	}