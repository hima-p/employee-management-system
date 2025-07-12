package com.ems.department_service.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class EmployeeLookUpDto {
    private Long id;
    private String name;

}
