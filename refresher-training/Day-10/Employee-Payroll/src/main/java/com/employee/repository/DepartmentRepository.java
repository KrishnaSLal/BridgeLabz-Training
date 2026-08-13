package com.employee.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.employee.entity.Department;

public interface DepartmentRepository
        extends ListCrudRepository<Department, Integer> {

}