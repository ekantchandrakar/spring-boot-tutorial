package com.ekant.tutorial.application.service;

import com.ekant.tutorial.application.entity.Department;
import com.ekant.tutorial.application.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                                .departmentName("IT")
                                .getDepartmentAddress("Hyderabad")
                                .departmentCode("IT-05")
                                .departmentId(1L).build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Department Name")
    public void whenValidDepartmentByNameThenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}