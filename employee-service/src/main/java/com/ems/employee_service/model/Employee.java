package com.ems.employee_service.model;


import com.ems.employee_service.dto.EmployeeLookUpDto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
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
