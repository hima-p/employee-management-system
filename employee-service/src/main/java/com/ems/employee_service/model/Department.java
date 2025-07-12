package com.ems.employee_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Department {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "department_head_id")
    private Employee departmentHead;

}
