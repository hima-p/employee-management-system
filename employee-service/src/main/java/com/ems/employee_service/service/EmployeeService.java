package com.ems.employee_service.service;

import com.ems.employee_service.dto.EmployeeDto;
import com.ems.employee_service.dto.EmployeeLookUpDto;
import com.ems.employee_service.model.Employee;
import org.springframework.data.domain.Page;


import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto dto) ;
    public Employee updateEmployee(Long id, EmployeeDto dto);
    public void updateEmployeeDepartment(Long empId, Long deptId) ;
    public Page<Employee> getAllEmployees(Pageable pageable) ;
    public List<EmployeeLookUpDto> getEmployeeLookup() ;
}
