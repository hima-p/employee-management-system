package com.ems.employee_service.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeDto {
        private Long id;
        private String name;
        private String dateOfBirth;
        private BigDecimal salary;
        private String address;
        private String role;
        private String joiningDate;
        private BigDecimal yearlyBonusPercentage;
        private DepartmentDto department;
        private EmployeeLookUpDto reportingManager;
}
