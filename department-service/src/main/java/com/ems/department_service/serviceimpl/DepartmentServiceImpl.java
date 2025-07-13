package com.ems.department_service.serviceimpl;

import com.ems.department_service.client.EmployeeClient;
import com.ems.department_service.dto.DepartmentDto;
import com.ems.department_service.dto.EmployeeDto;
import com.ems.department_service.model.Department;
import com.ems.department_service.repository.DepartmentRepository;
import com.ems.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeClient employeeClient;


    @Override
    public Department createDepartment(Department request) {
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Department name is required");
        }
        if (request.getDepartmentHeadId() == null) {
            throw new IllegalArgumentException("Department head ID is required");
        }
        // Optionally check if department head exists using EmployeeService
        if (request.getCreationDate() == null) {
            request.setCreationDate(java.time.LocalDate.now());
        }
        return departmentRepository.save(request);
    }
    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existing = departmentRepository.findById(id);
        if (existing.isPresent()) {
            Department department = existing.get();
            department.setName(updatedDepartment.getName());
            department.setCreationDate(updatedDepartment.getCreationDate());
            department.setDepartmentHeadId(updatedDepartment.getDepartmentHeadId());
            return departmentRepository.save(department);
        } else {
            throw new RuntimeException("Department not found with id: " + id);
        }
    }

    public void deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot delete. Department not found with id: " + id);
        }
    }
    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + id));
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Page<Department> getAllDepartmentsPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return departmentRepository.findAll(pageable);
    }
    @Override
    public DepartmentDto getDepartmentWithEmployees(Long id) {
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Department not found"));

            List<EmployeeDto> employees = employeeClient.getEmployeesByDepartment(id);

            DepartmentDto dto = new DepartmentDto();
            dto.setId(department.getId());
            dto.setName(department.getName());
            dto.setCreationDate(department.getCreationDate().toString());
            dto.setDepartmentHeadId(department.getDepartmentHeadId());
            dto.setEmployees(employees);

            return dto;
        }
}

