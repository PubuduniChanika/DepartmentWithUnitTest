package com.example.masterclass.controller;

import com.example.masterclass.entity.Department;
import com.example.masterclass.error.DepartmentNotFoundException;
import com.example.masterclass.service.DepartmentService;
import com.example.masterclass.service.DepartmentServiceImpl;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartment(@PathVariable("id") Long Id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartment(Id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long Id){
        departmentService.deleteDepartment(Id);
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long Id, @RequestBody Department department){
        return departmentService.updateDepartment(Id,department);

    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
