package com.lms.controller;

import com.lms.dto.EmployeeRequestDTO;
import com.lms.dto.EmployeeResponseDTO;
import com.lms.entity.Employee;
import com.lms.service.EmployeeService;
import com.lms.util.EmployeeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeRequestDTO dto) {
        Employee saved = employeeService.saveEmployee(EmployeeMapper.toEntity(dto));
        return ResponseEntity.ok(EmployeeMapper.toResponseDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(EmployeeMapper.toResponseDTO(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO dto) {
        Employee updated = employeeService.updateEmployee(id, EmployeeMapper.toEntity(dto));
        return ResponseEntity.ok(EmployeeMapper.toResponseDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees()
                .stream()
                .map(EmployeeMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }
}