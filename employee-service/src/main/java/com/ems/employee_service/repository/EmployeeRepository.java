package com.ems.employee_service.repository;

import com.ems.employee_service.model.Department;
import com.ems.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    List<Employee> findByDepartmentId(Long departmentId, Pageable pageable);
    Optional<Department> findByDepartmentId(Long departmentId);
    Optional<Object> findById(Employee reportingManagerId);
}