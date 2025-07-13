package com.ems.department_service.dto;
import lombok.Data;

import java.util.List;


@Data
public class DepartmentDto {
        private Long id;
        private String name;
        private String creationDate;
        private Long departmentHeadId;
        private List<EmployeeDto> employees;
}
