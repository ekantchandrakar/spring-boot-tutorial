package com.ekant.tutorial.application.service;

import com.ekant.tutorial.application.entity.Department;
import com.ekant.tutorial.application.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
