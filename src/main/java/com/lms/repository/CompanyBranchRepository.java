package com.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.CompanyBranch;


public interface CompanyBranchRepository extends JpaRepository<CompanyBranch, Integer> {
Optional	<CompanyBranch> findByEmail(String email);
Optional<CompanyBranch> findByAddressContainingIgnoreCase(String address);
	
}
