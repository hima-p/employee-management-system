package com.ems.department_service.dto;
import com.ems.department_service.model.Employee;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;


@Data
public class DepartmentDto {
        private Long id;
        private String name;
        private String creationDate;
        private Employee departmentHead;
        private List<EmployeeLookUpDto> employees;
}
