package com.ekant.tutorial.application.service;

import com.ekant.tutorial.application.entity.Department;
import com.ekant.tutorial.application.exception.DepartmentNotFoundException;
import com.ekant.tutorial.application.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if (departmentOptional.isEmpty()) {
            throw new DepartmentNotFoundException("Department Not Found...");
        }

        return departmentOptional.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if (departmentOptional.isEmpty()) {
            throw new IllegalStateException("Id is not present");
        }

        Department depDB = departmentOptional.get();

        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getGetDepartmentAddress()) && !"".equalsIgnoreCase(department.getGetDepartmentAddress())) {
            depDB.setGetDepartmentAddress(department.getGetDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
