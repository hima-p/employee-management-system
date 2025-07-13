package com.ems.department_service.client;

import com.ems.department_service.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8081") // use Eureka service name later
public interface EmployeeClient {

        @GetMapping("/api/employees/by-department/{deptId}")
        List<EmployeeDto> getEmployeesByDepartment(@PathVariable("deptId") Long deptId);
}

