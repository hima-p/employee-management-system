package com.ems.employee_service.controller;

import com.ems.employee_service.dto.EmployeeDto;
import com.ems.employee_service.model.Employee;
import com.ems.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
        EmployeeDto responseDto = employeeService.createEmployee(dto);
        return ResponseEntity.ok(responseDto);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto dto) { /* ... */
//    }
//
//    @PatchMapping("/{id}/department")
//    public ResponseEntity<Void> updateEmployeeDepartment(@PathVariable Long id, @RequestParam Long departmentId) { /* ... */ }
//
//    @GetMapping
//    public ResponseEntity<Page<EmployeeDto>> getAllEmployees(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "20") int size,
//            @RequestParam(required = false) Boolean lookup) { /* ... */ }
}
