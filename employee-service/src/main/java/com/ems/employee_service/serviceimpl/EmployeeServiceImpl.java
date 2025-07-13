package com.ems.employee_service.serviceimpl;

import com.ems.employee_service.dto.EmployeeLookUpDto;
import com.ems.employee_service.model.Employee;
import com.ems.employee_service.repository.EmployeeRepository;
import com.ems.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{


        @Autowired
        private EmployeeRepository employeeRepository;


        @Override
        public Employee createEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }

        @Override
        public Employee updateEmployee(Long id, Employee updatedEmployee) {
            Optional<Employee> optional = employeeRepository.findById(id);
            if (optional.isPresent()) {
                Employee existing = optional.get();
                existing.setName(updatedEmployee.getName());
                existing.setDateOfBirth(updatedEmployee.getDateOfBirth());
                existing.setSalary(updatedEmployee.getSalary());
                existing.setAddress(updatedEmployee.getAddress());
                existing.setRole(updatedEmployee.getRole());
                existing.setJoiningDate(updatedEmployee.getJoiningDate());
                existing.setYearlyBonusPercentage(updatedEmployee.getYearlyBonusPercentage());
                existing.setDepartmentId(updatedEmployee.getDepartmentId());
                existing.setReportingManagerId(updatedEmployee.getReportingManagerId());
                return employeeRepository.save(existing);
            } else {
                throw new RuntimeException("Employee not found with id: " + id);
            }
        }

        @Override
        public void deleteEmployee(Long id) {
            if (employeeRepository.existsById(id)) {
                employeeRepository.deleteById(id);
            } else {
                throw new RuntimeException("Cannot delete. Employee not found with id: " + id);
            }
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

