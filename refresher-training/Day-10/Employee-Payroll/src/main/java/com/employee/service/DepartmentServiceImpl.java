package com.employee.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;
import com.employee.entity.Department;
import com.employee.exception.DepartmentNotFoundException;
import com.employee.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository) {

        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponseDTO addDepartment(
            DepartmentRequestDTO dto) {

        Department department = new Department();

        department.setName(dto.getName());

        Department savedDepartment =
                departmentRepository.save(department);

        return convertToResponseDTO(savedDepartment);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .toList();
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(int id) {

        Department department =
                departmentRepository.findById(id)
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: " + id
                    ));

        return convertToResponseDTO(department);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(
            int id,
            DepartmentRequestDTO dto) {

        Department department =
                departmentRepository.findById(id)
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: " + id
                    ));

        department.setName(dto.getName());

        Department updatedDepartment =
                departmentRepository.save(department);

        return convertToResponseDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(int id) {

        Department department =
                departmentRepository.findById(id)
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: " + id
                    ));

        departmentRepository.delete(department);
    }

    private DepartmentResponseDTO convertToResponseDTO(
            Department department) {

        return new DepartmentResponseDTO(
                department.getId(),
                department.getName()
        );
    }
}