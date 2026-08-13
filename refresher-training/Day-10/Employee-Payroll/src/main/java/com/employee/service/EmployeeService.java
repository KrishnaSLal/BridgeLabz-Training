package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(int id);

    EmployeeResponseDTO updateEmployee(
            int id,
            EmployeeRequestDTO request);

    void deleteEmployee(int id);
}