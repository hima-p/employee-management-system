package com.ems.department_service.serviceimpl;

import com.ems.department_service.dto.DepartmentDto;
import com.ems.department_service.model.Department;
import com.ems.department_service.repository.DepartmentRepository;
import com.ems.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public Department createDepartment(Department request) {
        return null;
    }

    @Override
    public Department updateDepartment(Long id, DepartmentDto dto) {
        return null;
    }

    @Override
    public void deleteDepartment(Long id) {

    }

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return null;
    }

    @Override
    public Department getDepartmentWithEmployees(Long id) {
        return null;
    }
}

