package com.example.masterclass.service;

import com.example.masterclass.entity.Department;
import com.example.masterclass.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartment(Long Id) throws DepartmentNotFoundException;

    public void deleteDepartment(Long id);

    public Department updateDepartment(Long Id, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
