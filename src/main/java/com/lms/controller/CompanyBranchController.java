package com.lms.controller;

import com.lms.dto.CompanyBranchDto;
import com.lms.entity.CompanyBranch;
import com.lms.entity.Employee;
import com.lms.exception.CompanyBranchNotFoundException;
import com.lms.exception.EmployeeNotFoundException;
import com.lms.service.CompanyBranchServiceImpl;
import com.lms.util.CompanyBranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/branches")
public class CompanyBranchController {

    @Autowired
    private CompanyBranchServiceImpl companyBranchServiceImpl;

    private final CompanyBranchMapper mapper = new CompanyBranchMapper();

    // ✅ Show branch list + add form
    @GetMapping("/all")
    public String getAllBranches(Model model) {
        List<CompanyBranch> branches = companyBranchServiceImpl.allCompanyBranch();
        List<CompanyBranchDto> dtos = branches.stream()
                                              .map(mapper::toDto)
                                              .collect(Collectors.toList());
        model.addAttribute("branches", dtos);
        model.addAttribute("branch", new CompanyBranchDto()); // needed for add form
        return "branch-list";
    }

    // ✅ Save new branch
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute("branch") CompanyBranchDto dto) {
        companyBranchServiceImpl.saveBranch(mapper.toEntity(dto));
        return "redirect:/branches/all";
    }

    // ✅ Show edit form with values filled
    @GetMapping("/edit/{id}")
    public String showEditBranchForm(@PathVariable int id, Model model) {
        CompanyBranch branch = companyBranchServiceImpl.companyBranchById(id);
        model.addAttribute("branch", mapper.toDto(branch));

        List<CompanyBranch> branches = companyBranchServiceImpl.allCompanyBranch();
        model.addAttribute("branches", branches.stream().map(mapper::toDto).collect(Collectors.toList()));

        return "branch-list"; // reuse branch-list but with form pre-filled
    }

    // ✅ Handle update
    @PostMapping("/update/{id}")
    public String updateBranch(@PathVariable int id, @ModelAttribute("branch") CompanyBranchDto dto) {
        companyBranchServiceImpl.updateCompanyBranch(mapper.toEntity(dto), id);
        return "redirect:/branches/all";
    }

    // ✅ Delete branch
    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable int id) {
        companyBranchServiceImpl.deleteCompanyBranch(id);
        return "redirect:/branches/all";
    }
    @GetMapping("/{id}")
    public String showById(@PathVariable int id,Model model)
    {
    	 try {
             CompanyBranch companyBranch = companyBranchServiceImpl.companyBranchById(id);
             model.addAttribute("branch", companyBranch);
             return "one-branch-view"; // 👉 Create employee-details.html if needed
         } catch (CompanyBranchNotFoundException e) {
             return "redirect:/branches/list";
         }
    	
    }

    @GetMapping("/search")
    public String searchBranch(@RequestParam("keyword") String keyword, Model model) {
        CompanyBranch companyBranch = companyBranchServiceImpl
                .findByAddressContainingIgnoreCase(keyword)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        model.addAttribute("branch", companyBranch);
        return "one-branch-view"; // should match your Thymeleaf template
    }

}
