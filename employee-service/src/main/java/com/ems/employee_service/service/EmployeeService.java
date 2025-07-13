package com.ems.employee_service.service;

import com.ems.employee_service.dto.EmployeeDto;
import com.ems.employee_service.dto.EmployeeLookUpDto;
import com.ems.employee_service.model.Employee;
import org.springframework.data.domain.Page;


import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee dto) ;
    public Employee updateEmployee(Long id, Employee dto);
    public void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Page<Employee> getAllEmployeesPaged(int page, int size);
    List<EmployeeLookUpDto> getEmployeeNamesAndIds();

}
