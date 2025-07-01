package com.lms.util;

import com.lms.dto.CompanyBranchDto;
import com.lms.entity.CompanyBranch;

public class CompanyBranchMapper {
	public CompanyBranch toEntity(CompanyBranchDto companyBranchDto)
	{
		CompanyBranch companyBranch=new CompanyBranch();
		companyBranch.setAddress(companyBranchDto.getAddress());
		companyBranch.setBaranchId(companyBranchDto.getBaranchId());
		companyBranch.setContactNumber(companyBranchDto.getContactNumber());
		companyBranch.setEmail(companyBranchDto.getEmail());
		return companyBranch;
	}
	
	 public CompanyBranchDto toDto(CompanyBranch companyBranch) {
	        if (companyBranch == null) {
	            return null;
	        }

	        CompanyBranchDto dto = new CompanyBranchDto();
	        dto.setBaranchId(companyBranch.getBaranchId());
	        dto.setAddress(companyBranch.getAddress());
	        dto.setContactNumber(companyBranch.getContactNumber());
	        dto.setEmail(companyBranch.getEmail());
	        return dto;
	    }
}
