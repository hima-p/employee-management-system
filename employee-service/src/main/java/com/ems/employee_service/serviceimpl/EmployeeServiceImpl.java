package com.ems.employee_service.serviceimpl;



import com.ems.employee_service.dto.DepartmentDto;
import com.ems.employee_service.dto.EmployeeDto;
import com.ems.employee_service.dto.EmployeeLookUpDto;
import com.ems.employee_service.model.Department;
import com.ems.employee_service.model.Employee;
import com.ems.employee_service.repository.EmployeeRepository;
import com.ems.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {

            Employee employee = new Employee();
            employee.setName(dto.getName());
            employee.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
            employee.setSalary(dto.getSalary());
            employee.setAddress(dto.getAddress());
            employee.setRole(dto.getRole());
            employee.setJoiningDate(LocalDate.parse(dto.getJoiningDate()));
            employee.setYearlyBonusPercentage(dto.getYearlyBonusPercentage());
        if (dto.getDepartment() != null) {
            Department department = employeeRepository.findByDepartmentId(dto.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(department);
        }
        if (dto.getReportingManager() != null) {
            Employee manager = employeeRepository.findById(dto.getReportingManager().getId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            employee.setReportingManager(manager);
        }
            Employee saved = employeeRepository.save(employee);

            return mapToEmployeeDto(saved);
    }

    private EmployeeDto mapToEmployeeDto(Employee saved) {
        EmployeeDto responseDto = new EmployeeDto();
        responseDto.setId(saved.getId());
        responseDto.setName(saved.getName());
        responseDto.setDateOfBirth(String.valueOf(saved.getDateOfBirth()));
        responseDto.setSalary(saved.getSalary());
        responseDto.setAddress(saved.getAddress());
        responseDto.setRole(saved.getRole());
        responseDto.setJoiningDate(String.valueOf(saved.getJoiningDate()));
        responseDto.setYearlyBonusPercentage(saved.getYearlyBonusPercentage());

        if (saved.getDepartment() != null) {
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setName(saved.getDepartment().getName());
            responseDto.setDepartment(departmentDto);
        }

        if (saved.getReportingManager() != null) {
            EmployeeLookUpDto reportingManagerDto = new EmployeeLookUpDto();
            reportingManagerDto.setName(saved.getReportingManager().getName());
            reportingManagerDto.setId(saved.getReportingManager().getId());
            responseDto.setReportingManager(reportingManagerDto);
        }
        return responseDto;
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDto dto) {
        return null;
    }

    @Override
    public void updateEmployeeDepartment(Long empId, Long deptId) {

    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return null;
    }

    @Override
    public List<EmployeeLookUpDto> getEmployeeLookup() {
        return List.of();
    }
}
