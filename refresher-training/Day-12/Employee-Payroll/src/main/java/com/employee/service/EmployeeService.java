package com.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.dto.EmployeeSearchDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request);

    Page<EmployeeResponseDTO> getAllEmployees(
            Pageable pageable);

    EmployeeResponseDTO getEmployeeById(
            Long id);

    EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO request);

    void deleteEmployee(Long id);

    Page<EmployeeResponseDTO> getEmployees(
            int page,
            int size,
            String sortBy,
            String direction);

    Page<EmployeeResponseDTO> searchEmployees(
            EmployeeSearchDTO searchDTO,
            int page,
            int size,
            String sortBy,
            String direction);
}