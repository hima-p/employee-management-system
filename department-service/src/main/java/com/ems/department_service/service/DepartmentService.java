package com.ems.department_service.service;


import com.ems.department_service.dto.DepartmentDto;
import com.ems.department_service.model.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {

    public Department createDepartment(Department dto);
    public Department updateDepartment(Long id, Department dto) ;
    public void deleteDepartment(Long id);
    List<Department> getAllDepartments();
    Page<Department> getAllDepartmentsPaged(int page, int size);
    DepartmentDto getDepartmentWithEmployees(Long id);
    Department getDepartmentById(Long id);
}


