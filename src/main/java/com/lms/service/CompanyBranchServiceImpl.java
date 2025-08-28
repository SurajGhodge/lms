package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.CompanyBranch;
import com.lms.exception.CompanyBranchNotFoundException;
import com.lms.repository.CompanyBranchRepository;
@Service
public class CompanyBranchServiceImpl implements CompanyBranchService {
	@Autowired
	CompanyBranchRepository companyBranchRepository;
	@Override
	public CompanyBranch saveBranch(CompanyBranch companyBranch) {
		
		return companyBranchRepository.save(companyBranch);
	}

	@Override
	public CompanyBranch updateCompanyBranch(CompanyBranch companyBranch, int branchId) {
		Optional<CompanyBranch> existingCompanyBranchOpt=companyBranchRepository.findById(branchId);;
		if(existingCompanyBranchOpt.isPresent())
		{
			CompanyBranch existingCompanyBranch=companyBranchRepository.findById(branchId).get();
			existingCompanyBranch.setAddress(companyBranch.getAddress());
			//existingCompanyBranch.setBaranchId(companyBranch.getBaranchId());
			existingCompanyBranch.setContactNumber(companyBranch.getContactNumber());
			existingCompanyBranch.setEmail(companyBranch.getEmail());
			return companyBranchRepository.save(existingCompanyBranch);
		}
		return null;
	}

	@Override
	public CompanyBranch companyBranchById(int branchId) {
		// TODO Auto-generated method stub
		return companyBranchRepository.findById(branchId).orElseThrow(() -> new CompanyBranchNotFoundException("Branch not found with ID: " + branchId));
	}

	@Override
	public List<CompanyBranch> allCompanyBranch() {
		// TODO Auto-generated method stub
		return companyBranchRepository.findAll();
	}

	public void deleteCompanyBranch(int id) {
		// TODO Auto-generated method stub
		companyBranchRepository.deleteById(id);
	}

	 @Override
	    public Optional<CompanyBranch> findByAddressContainingIgnoreCase(String address) {
	        return companyBranchRepository.findByAddressContainingIgnoreCase(address);
	    }

}
