package com.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.dto.EmployeeSearchDTO;
import com.employee.entity.Employee;
import com.employee.exception.DepartmentNotFoundException;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            EmployeeMapper employeeMapper,
            DepartmentRepository departmentRepository) {

        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
    }

    // =========================
    // CREATE EMPLOYEE
    // =========================

    @Override
    public EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request) {

        logger.info(
                "Creating employee with name: {}",
                request.getName()
        );

        departmentRepository
                .findById(request.getDepartmentId())
                .orElseThrow(() -> {

                    logger.warn(
                            "Department not found with id: {} while creating employee",
                            request.getDepartmentId()
                    );

                    return new DepartmentNotFoundException(
                            "Department not found with id: "
                                    + request.getDepartmentId()
                    );
                });

        Employee employee =
                employeeMapper.toEntity(request);

        Employee savedEmployee =
                employeeRepository.save(employee);

        logger.info(
                "Employee created successfully with id: {}",
                savedEmployee.getId()
        );

        return employeeMapper.toResponseDTO(savedEmployee);
    }

    // =========================
    // GET ALL EMPLOYEES
    // =========================

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(
            Pageable pageable) {

        logger.info(
                "Fetching all employees. Page: {}, Size: {}",
                pageable.getPageNumber(),
                pageable.getPageSize()
        );

        Page<EmployeeResponseDTO> employees =
                employeeRepository
                        .findAll(pageable)
                        .map(employeeMapper::toResponseDTO);

        logger.info(
                "Successfully fetched {} employees",
                employees.getNumberOfElements()
        );

        return employees;
    }

    // =========================
    // PAGINATION + SORTING
    // =========================

    @Override
    public Page<EmployeeResponseDTO> getEmployees(
            int page,
            int size,
            String sortBy,
            String direction) {

        logger.info(
                "Fetching employees with pagination. Page: {}, Size: {}, SortBy: {}, Direction: {}",
                page,
                size,
                sortBy,
                direction
        );

        Sort sort;

        if (direction.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        sort
                );

        Page<EmployeeResponseDTO> employees =
                employeeRepository
                        .findAll(pageable)
                        .map(employeeMapper::toResponseDTO);

        logger.info(
                "Pagination completed successfully. Total employees: {}",
                employees.getTotalElements()
        );

        return employees;
    }

    // =========================
    // GET EMPLOYEE BY ID
    // =========================

    @Override
    public EmployeeResponseDTO getEmployeeById(
            Long id) {

        logger.info(
                "Fetching employee with id: {}",
                id
        );

        Employee employee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(() -> {

                            logger.warn(
                                    "Employee not found with id: {}",
                                    id
                            );

                            return new EmployeeNotFoundException(
                                    "Employee not found with id: " + id
                            );
                        });

        logger.info(
                "Employee found successfully with id: {}",
                id
        );

        return employeeMapper.toResponseDTO(employee);
    }

    // =========================
    // UPDATE EMPLOYEE
    // =========================

    @Override
    public EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO request) {

        logger.info(
                "Updating employee with id: {}",
                id
        );

        Employee employee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(() -> {

                            logger.warn(
                                    "Employee not found with id: {} while updating",
                                    id
                            );

                            return new EmployeeNotFoundException(
                                    "Employee not found with id: " + id
                            );
                        });

        departmentRepository
                .findById(request.getDepartmentId())
                .orElseThrow(() -> {

                    logger.warn(
                            "Department not found with id: {} while updating employee {}",
                            request.getDepartmentId(),
                            id
                    );

                    return new DepartmentNotFoundException(
                            "Department not found with id: "
                                    + request.getDepartmentId()
                    );
                });

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(
                request.getDepartmentId()
        );

        Employee updatedEmployee =
                employeeRepository.save(employee);

        logger.info(
                "Employee updated successfully with id: {}",
                id
        );

        return employeeMapper.toResponseDTO(updatedEmployee);
    }

    // =========================
    // DELETE EMPLOYEE
    // =========================

    @Override
    public void deleteEmployee(Long id) {

        logger.info(
                "Deleting employee with id: {}",
                id
        );

        Employee employee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(() -> {

                            logger.warn(
                                    "Employee not found with id: {} while deleting",
                                    id
                            );

                            return new EmployeeNotFoundException(
                                    "Employee not found with id: " + id
                            );
                        });

        employeeRepository.delete(employee);

        logger.info(
                "Employee deleted successfully with id: {}",
                id
        );
    }

    // =========================
    // QUERY BY EXAMPLE
    // + PAGINATION
    // + SORTING
    // =========================

    @Override
    public Page<EmployeeResponseDTO> searchEmployees(
            EmployeeSearchDTO searchDTO,
            int page,
            int size,
            String sortBy,
            String direction) {

        logger.info(
                "Searching employees. Page: {}, Size: {}, SortBy: {}, Direction: {}",
                page,
                size,
                sortBy,
                direction
        );

        // Create probe object
        Employee employee = new Employee();

        employee.setName(searchDTO.getName());
        employee.setEmail(searchDTO.getEmail());
        employee.setPhone(searchDTO.getPhone());

        // Create matcher
        ExampleMatcher matcher =
                ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withStringMatcher(
                                ExampleMatcher.StringMatcher.CONTAINING
                        );

        // Create example
        Example<Employee> example =
                Example.of(employee, matcher);

        // Sorting
        Sort sort;

        if (direction.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        } else {
            sort = Sort.by(sortBy).ascending();
        }

        // Pagination
        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        sort
                );

        // Execute QBE
        Page<EmployeeResponseDTO> results =
                employeeRepository
                        .findAll(example, pageable)
                        .map(employeeMapper::toResponseDTO);

        logger.info(
                "Employee search completed. Found {} employees",
                results.getTotalElements()
        );

        return results;
    }
}