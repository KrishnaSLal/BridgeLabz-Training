package com.employee.mapper;

import org.springframework.stereotype.Component;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;
import com.employee.entity.Department;

@Component
public class DepartmentMapper {

    public Department toEntity(
            DepartmentRequestDTO request) {

        Department department = new Department();

        department.setName(request.getName());

        return department;
    }

    public DepartmentResponseDTO toResponseDTO(
            Department department) {

        return new DepartmentResponseDTO(
                department.getId(),
                department.getName()
        );
    }
}