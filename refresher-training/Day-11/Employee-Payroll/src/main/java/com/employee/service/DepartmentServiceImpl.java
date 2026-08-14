package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;
import com.employee.entity.Department;
import com.employee.exception.DepartmentNotFoundException;
import com.employee.mapper.DepartmentMapper;
import com.employee.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl
        implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository,
            DepartmentMapper departmentMapper) {

        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentResponseDTO addDepartment(
            DepartmentRequestDTO request) {

        Department department =
                departmentMapper.toEntity(request);

        Department savedDepartment =
                departmentRepository.save(department);

        return departmentMapper
                .toResponseDTO(savedDepartment);
    }

    @Override
    public List<DepartmentResponseDTO>
            getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toResponseDTO)
                .toList();
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(
            Long id) {

        Department department =
                departmentRepository.findById(id)
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: " + id
                    ));

        return departmentMapper
                .toResponseDTO(department);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(
            Long id,
            DepartmentRequestDTO request) {

        Department department =
                departmentRepository.findById(id)
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: " + id
                    ));

        department.setName(request.getName());

        Department updatedDepartment =
                departmentRepository.save(department);

        return departmentMapper
                .toResponseDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department =
                departmentRepository.findById(id)
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: " + id
                    ));

        departmentRepository.delete(department);
    }
}