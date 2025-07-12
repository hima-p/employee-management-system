package com.ems.employee_service.dto;

import lombok.Data;
@Data
public class DepartmentDto {
        private Long id;
        private String name;
        private String creationDate;
        private EmployeeLookUpDto departmentHead;
    }

