package com.lms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.CompanyBranchDto;
import com.lms.entity.CompanyBranch;
import com.lms.service.CompanyBranchServiceImpl;
import com.lms.util.CompanyBranchMapper;

@RestController
	@RequestMapping("/api/branches")
	public class CompanyBranchController {
	    @Autowired
	    private CompanyBranchServiceImpl companyBranchServiceImpl;
	    private final CompanyBranchMapper mapper = new CompanyBranchMapper();
	    @PostMapping("/addbranch")
	    public ResponseEntity<CompanyBranchDto> saveBranch(@RequestBody CompanyBranchDto dto) {
	        CompanyBranch savedBranch = companyBranchServiceImpl.saveBranch(mapper.toEntity(dto));
	        return ResponseEntity.ok(mapper.toDto(savedBranch));
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<CompanyBranchDto> updateBranch(@PathVariable int id, @RequestBody CompanyBranchDto dto) {
	        CompanyBranch updatedBranch = companyBranchServiceImpl.updateCompanyBranch(mapper.toEntity(dto), id);
	        if (updatedBranch == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(mapper.toDto(updatedBranch));
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<CompanyBranchDto> getBranchById(@PathVariable int id) {
	        CompanyBranch branch = companyBranchServiceImpl.companyBranchById(id);
	        return ResponseEntity.ok(mapper.toDto(branch));
	    }
	    @GetMapping("/allbranches")
	    public ResponseEntity<List<CompanyBranchDto>> getAllBranches() {
	        List<CompanyBranch> branches = companyBranchServiceImpl.allCompanyBranch();
	        List<CompanyBranchDto> dtos = branches.stream().map(mapper::toDto).collect(Collectors.toList());
	        return ResponseEntity.ok(dtos);
	    }
	}