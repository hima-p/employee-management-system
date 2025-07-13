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

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
            Employee saved = employeeService.createEmployee(employee);
            return ResponseEntity.ok(saved);
    }

        @PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
            Employee updated = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updated);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok("Employee deleted successfully");
        }
    }

