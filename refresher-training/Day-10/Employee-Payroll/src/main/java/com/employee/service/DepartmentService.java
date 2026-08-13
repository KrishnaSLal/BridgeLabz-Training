package com.employee.service;

import java.util.List;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;

public interface DepartmentService {

    DepartmentResponseDTO addDepartment(
            DepartmentRequestDTO departmentRequestDTO);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(int id);

    DepartmentResponseDTO updateDepartment(
            int id,
            DepartmentRequestDTO departmentRequestDTO);

    void deleteDepartment(int id);
}