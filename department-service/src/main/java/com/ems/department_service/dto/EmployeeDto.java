package com.ems.department_service.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private BigDecimal salary;
    private String address;
    private String role;
    private LocalDate joiningDate;
    private BigDecimal yearlyBonusPercentage;
    private Long departmentId;
    @Column(nullable = true)
    private Long reportingManagerId;


}
