package com.employee.mapper;

import org.springframework.stereotype.Component;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.entity.Employee;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequestDTO request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(request.getDepartmentId());

        return employee;
    }

    public EmployeeResponseDTO toResponseDTO(Employee employee) {

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getSalary(),
                employee.getDepartmentId()
        );
    }
}