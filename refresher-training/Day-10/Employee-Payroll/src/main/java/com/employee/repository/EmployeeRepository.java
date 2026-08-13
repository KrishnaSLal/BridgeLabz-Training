package com.employee.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.employee.entity.Employee;

public interface EmployeeRepository
        extends ListCrudRepository<Employee, Integer> {

}