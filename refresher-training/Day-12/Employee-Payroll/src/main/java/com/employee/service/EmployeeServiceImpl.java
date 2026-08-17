package com.employee.service;

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
public class EmployeeServiceImpl
        implements EmployeeService {

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

        departmentRepository
                .findById(request.getDepartmentId())
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: "
                        + request.getDepartmentId()
                    ));

        Employee employee =
                employeeMapper.toEntity(request);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return employeeMapper
                .toResponseDTO(savedEmployee);
    }

    // =========================
    // GET ALL EMPLOYEES
    // =========================

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(
            Pageable pageable) {

        return employeeRepository
                .findAll(pageable)
                .map(employeeMapper::toResponseDTO);
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

        return employeeRepository
                .findAll(pageable)
                .map(employeeMapper::toResponseDTO);
    }

    // =========================
    // GET EMPLOYEE BY ID
    // =========================

    @Override
    public EmployeeResponseDTO getEmployeeById(
            Long id) {

        Employee employee =
                employeeRepository
                .findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + id
                    ));

        return employeeMapper
                .toResponseDTO(employee);
    }

    // =========================
    // UPDATE EMPLOYEE
    // =========================

    @Override
    public EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO request) {

        Employee employee =
                employeeRepository
                .findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + id
                    ));

        departmentRepository
                .findById(request.getDepartmentId())
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: "
                        + request.getDepartmentId()
                    ));

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(
                request.getDepartmentId()
        );

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return employeeMapper
                .toResponseDTO(updatedEmployee);
    }

    // =========================
    // DELETE EMPLOYEE
    // =========================

    @Override
    public void deleteEmployee(Long id) {

        Employee employee =
                employeeRepository
                .findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + id
                    ));

        employeeRepository.delete(employee);
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
        return employeeRepository
                .findAll(example, pageable)
                .map(employeeMapper::toResponseDTO);
    }
}