package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.entity.Employee;
import com.employee.exception.DepartmentNotFoundException;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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

    @Override
    public EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO request) {

        departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: "
                        + request.getDepartmentId()
                    ));

        Employee employee =
                employeeMapper.toEntity(request);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return employeeMapper.toResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(int id) {

        Employee employee =
                employeeRepository.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + id
                    ));

        return employeeMapper.toResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(
            int id,
            EmployeeRequestDTO request) {

        Employee employee =
                employeeRepository.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + id
                    ));

        departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() ->
                    new DepartmentNotFoundException(
                        "Department not found with id: "
                        + request.getDepartmentId()
                    ));

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(request.getDepartmentId());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return employeeMapper.toResponseDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(int id) {

        Employee employee =
                employeeRepository.findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "Employee not found with id: " + id
                    ));

        employeeRepository.delete(employee);
    }
}