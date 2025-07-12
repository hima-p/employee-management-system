package com.ems.department_service.controller;

import com.ems.department_service.dto.DepartmentDto;
import com.ems.department_service.model.Department;
import com.ems.department_service.repository.DepartmentRepository;
import com.ems.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Department> addDepartment(@RequestBody Department request) {
        Department response = departmentService.createDepartment(request);
        return ResponseEntity.ok(response);
    }
}