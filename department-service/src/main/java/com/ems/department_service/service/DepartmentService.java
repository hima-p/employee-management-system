package com.ems.department_service.service;

import com.ems.department_service.dto.DepartmentDto;
import com.ems.department_service.model.Department;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface DepartmentService {

    public Department createDepartment(Department dto);
    public Department updateDepartment(Long id, Department dto) ;
    public void deleteDepartment(Long id);
    public Page<Department> getAllDepartments(Pageable pageable) ;
    public Department getDepartmentWithEmployees(Long id);
}


