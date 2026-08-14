package com.employee.service;

import java.util.List;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;

public interface DepartmentService {

    DepartmentResponseDTO addDepartment(
            DepartmentRequestDTO request);

    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long id);

    DepartmentResponseDTO updateDepartment(
            Long id,
            DepartmentRequestDTO request);

    void deleteDepartment(Long id);
}