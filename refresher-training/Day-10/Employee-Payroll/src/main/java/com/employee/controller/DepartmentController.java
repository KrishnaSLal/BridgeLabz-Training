package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.dto.DepartmentRequestDTO;
import com.employee.dto.DepartmentResponseDTO;
import com.employee.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(
            DepartmentService departmentService) {

        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> addDepartment(
            @RequestBody DepartmentRequestDTO dto) {

        DepartmentResponseDTO response =
                departmentService.addDepartment(dto);

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDTO>>
            getAllDepartments() {

        return ResponseEntity.ok(
                departmentService.getAllDepartments()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO>
            getDepartmentById(@PathVariable int id) {

        return ResponseEntity.ok(
                departmentService.getDepartmentById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO>
            updateDepartment(
                    @PathVariable int id,
                    @RequestBody DepartmentRequestDTO dto) {

        return ResponseEntity.ok(
                departmentService.updateDepartment(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(
            @PathVariable int id) {

        departmentService.deleteDepartment(id);

        return ResponseEntity.noContent().build();
    }
}