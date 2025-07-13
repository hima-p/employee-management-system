package com.ems.employee_service.repository;

import com.ems.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Object> findById(Employee reportingManagerId);
}