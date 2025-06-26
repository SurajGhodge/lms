package com.lms.employee.controller;

import com.lms.employee.dto.EmployeeRequestDTO;
import com.lms.employee.dto.EmployeeResponseDTO;
import com.lms.employee.entity.Employee;
import com.lms.employee.service.EmployeeService;
import com.lms.employee.util.EmployeeMapper;

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

    @PostMapping
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

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees()
                .stream()
                .map(EmployeeMapper::toResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }
}