package com.employee.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.employee.dto.EmployeeRequestDTO;
import com.employee.dto.EmployeeResponseDTO;
import com.employee.dto.EmployeeSearchDTO;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(
            EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    // =========================
    // CREATE
    // =========================

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO>
            createEmployee(
                @Valid
                @RequestBody
                EmployeeRequestDTO request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    employeeService
                    .createEmployee(request)
                );
    }

    // =========================
    // GET ALL
    // =========================

    @GetMapping
    public ResponseEntity<Page<EmployeeResponseDTO>>
            getAllEmployees(
                Pageable pageable) {

        return ResponseEntity.ok(
                employeeService
                .getAllEmployees(pageable)
        );
    }

    // =========================
    // GET BY ID
    // =========================

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>
            getEmployeeById(
                @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeService
                .getEmployeeById(id)
        );
    }

    // =========================
    // UPDATE
    // =========================

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO>
            updateEmployee(
                @PathVariable Long id,
                @Valid
                @RequestBody
                EmployeeRequestDTO request) {

        return ResponseEntity.ok(
                employeeService
                .updateEmployee(id, request)
        );
    }

    // =========================
    // DELETE
    // =========================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>
            deleteEmployee(
                @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    // =========================
    // PAGINATION + SORTING
    // =========================

    @GetMapping("/page")
    public ResponseEntity<Page<EmployeeResponseDTO>>
            getEmployees(
                @RequestParam(defaultValue = "0")
                int page,

                @RequestParam(defaultValue = "5")
                int size,

                @RequestParam(defaultValue = "id")
                String sortBy,

                @RequestParam(defaultValue = "asc")
                String direction) {

        return ResponseEntity.ok(
                employeeService.getEmployees(
                    page,
                    size,
                    sortBy,
                    direction
                )
        );
    }

    // =========================
    // QUERY BY EXAMPLE
    // + PAGINATION
    // + SORTING
    // =========================

    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeResponseDTO>>
            searchEmployees(

                @ModelAttribute
                EmployeeSearchDTO searchDTO,

                @RequestParam(defaultValue = "0")
                int page,

                @RequestParam(defaultValue = "5")
                int size,

                @RequestParam(defaultValue = "id")
                String sortBy,

                @RequestParam(defaultValue = "asc")
                String direction) {

        return ResponseEntity.ok(
                employeeService.searchEmployees(
                    searchDTO,
                    page,
                    size,
                    sortBy,
                    direction
                )
        );
    }
}