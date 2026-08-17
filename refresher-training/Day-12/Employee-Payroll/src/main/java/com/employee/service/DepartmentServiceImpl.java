package com.employee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;
import com.employee.entity.Department;
import com.employee.exception.DepartmentNotFoundException;
import com.employee.mapper.DepartmentMapper;
import com.employee.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger =
            LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository,
            DepartmentMapper departmentMapper) {

        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    // =========================
    // CREATE DEPARTMENT
    // =========================

    @Override
    public DepartmentResponseDTO addDepartment(
            DepartmentRequestDTO request) {

        logger.info(
                "Creating department with name: {}",
                request.getName()
        );

        Department department =
                departmentMapper.toEntity(request);

        Department savedDepartment =
                departmentRepository.save(department);

        logger.info(
                "Department created successfully with id: {}",
                savedDepartment.getId()
        );

        return departmentMapper
                .toResponseDTO(savedDepartment);
    }

    // =========================
    // GET ALL DEPARTMENTS
    // =========================

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {

        logger.info(
                "Fetching all departments"
        );

        List<DepartmentResponseDTO> departments =
                departmentRepository
                        .findAll()
                        .stream()
                        .map(departmentMapper::toResponseDTO)
                        .toList();

        logger.info(
                "Successfully fetched {} departments",
                departments.size()
        );

        return departments;
    }

    // =========================
    // GET DEPARTMENT BY ID
    // =========================

    @Override
    public DepartmentResponseDTO getDepartmentById(
            Long id) {

        logger.info(
                "Fetching department with id: {}",
                id
        );

        Department department =
                departmentRepository
                        .findById(id)
                        .orElseThrow(() -> {

                            logger.warn(
                                    "Department not found with id: {}",
                                    id
                            );

                            return new DepartmentNotFoundException(
                                    "Department not found with id: " + id
                            );
                        });

        logger.info(
                "Department found successfully with id: {}",
                id
        );

        return departmentMapper
                .toResponseDTO(department);
    }

    // =========================
    // UPDATE DEPARTMENT
    // =========================

    @Override
    public DepartmentResponseDTO updateDepartment(
            Long id,
            DepartmentRequestDTO request) {

        logger.info(
                "Updating department with id: {}",
                id
        );

        Department department =
                departmentRepository
                        .findById(id)
                        .orElseThrow(() -> {

                            logger.warn(
                                    "Department not found with id: {} while updating",
                                    id
                            );

                            return new DepartmentNotFoundException(
                                    "Department not found with id: " + id
                            );
                        });

        department.setName(request.getName());

        Department updatedDepartment =
                departmentRepository.save(department);

        logger.info(
                "Department updated successfully with id: {}",
                id
        );

        return departmentMapper
                .toResponseDTO(updatedDepartment);
    }

    // =========================
    // DELETE DEPARTMENT
    // =========================

    @Override
    public void deleteDepartment(Long id) {

        logger.info(
                "Deleting department with id: {}",
                id
        );

        Department department =
                departmentRepository
                        .findById(id)
                        .orElseThrow(() -> {

                            logger.warn(
                                    "Department not found with id: {} while deleting",
                                    id
                            );

                            return new DepartmentNotFoundException(
                                    "Department not found with id: " + id
                            );
                        });

        departmentRepository.delete(department);

        logger.info(
                "Department deleted successfully with id: {}",
                id
        );
    }
}