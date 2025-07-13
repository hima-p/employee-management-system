package com.ems.department_service.model;
import com.ems.department_service.dto.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Department {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private LocalDate creationDate;
    private Long departmentHeadId;

}
