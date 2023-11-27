package com.ekant.tutorial.application.repository;

import com.ekant.tutorial.application.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentCode("ME-01")
                .getDepartmentAddress("Delhi")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindByIdThenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
}