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

import com.lms.dto.LeaveRequestDto;
import com.lms.dto.LeaveResponceDto;
import com.lms.entity.Employee;
import com.lms.entity.Leaves;
import com.lms.repository.EmployeeRepo;
import com.lms.service.LeavesServiceImpl;
import com.lms.util.LeaveMapper;
@RestController
@RequestMapping("/api/leaves")
public class LeaveController {
	  @Autowired
	    private LeavesServiceImpl leavesServiceImpl;
	  @Autowired
	  private EmployeeRepo employeeRepo;

	  @PostMapping("/apply/{id}")
	  public ResponseEntity<LeaveResponceDto> applyLeave(@PathVariable Long id,
	                                                     @RequestBody LeaveRequestDto request) {
	      Employee emp = employeeRepo.findById(id)
	          .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

	      Leaves leave = leavesServiceImpl.applyLeave(emp.getId(), request);
	      return ResponseEntity.ok(LeaveMapper.toResponceDto(leave));
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
	    @GetMapping("/all")
	    public ResponseEntity<List<Leaves>> getAllLeaves() {
	        List<Leaves> leaves = leavesServiceImpl.getAllLeaves();
	        return ResponseEntity.ok(leaves);
	    }
	    @PostMapping("/cancel/{leaveId}")
	    public ResponseEntity<String> cancelLeave(@PathVariable Long leaveId)
	    {
	    	leavesServiceImpl.cancelLeave(leaveId);
	    	return ResponseEntity.ok("Leave cancelled sucessfully");
	    }
	    @PutMapping("/approve/{leaveId}")
	    public ResponseEntity<String> approveLeave(@PathVariable Long leaveId)
	    {
	    	leavesServiceImpl.approveLeave(leaveId);
	    	return ResponseEntity.ok("leave approved successfully");
	    }
	    @PutMapping("/reject/{leaveId}")
	    public ResponseEntity<String> rejectLeave(@PathVariable Long leaveId)
	    {
	    	leavesServiceImpl.rejectLeave(leaveId);
	    	return ResponseEntity.ok("Leave rejected and leave balance restored ");
	    }
	}