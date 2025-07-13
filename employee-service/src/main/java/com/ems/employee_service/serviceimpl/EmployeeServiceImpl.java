package com.ems.employee_service.serviceimpl;

import com.ems.employee_service.dto.EmployeeLookUpDto;
import com.ems.employee_service.model.Employee;
import com.ems.employee_service.repository.EmployeeRepository;
import com.ems.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        }
        @Override
        public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
        }
       @Override
       public Page<Employee> getAllEmployeesPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
       }

       @Override
       public List<EmployeeLookUpDto> getEmployeeNamesAndIds() {
           return employeeRepository.findAll().stream()
                   .map(emp -> new EmployeeLookUpDto(emp.getId(), emp.getName()))
                   .collect(Collectors.toList());
    }

}

