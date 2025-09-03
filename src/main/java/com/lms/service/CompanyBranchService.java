package com.lms.service;

import java.util.List;
import java.util.Optional;

import com.lms.entity.CompanyBranch;

public interface CompanyBranchService {
	CompanyBranch saveBranch(CompanyBranch companyBranch);

	CompanyBranch updateCompanyBranch(CompanyBranch companyBranch, int branchId);

	CompanyBranch companyBranchById(int branchId);

	List<CompanyBranch> allCompanyBranch();

	Optional<CompanyBranch> findByAddressContainingIgnoreCase(String address);
}
