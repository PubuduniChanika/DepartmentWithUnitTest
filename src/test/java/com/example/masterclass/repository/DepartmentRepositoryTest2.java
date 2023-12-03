//package com.example.masterclass.repository;
//
//import com.example.masterclass.entity.Department;
//import jakarta.persistence.EntityManager;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
////@EntityScan(basePackages = "com.example.masterclass.entity")
//class DepartmentRepositoryTest {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @BeforeEach
//    void setUp() {
//        Department department =
//                Department.builder()
//                        .departmentName("ABZ")
//                        .departmentCode("666")
//                        .departmentAddress("Gampaha")
//                        .build();
//
//        entityManager.persist(department);
//    }
//    @Test
//    public void whenFindById_thenReturnDepartment(){
//        Department department = departmentRepository.findById(1L).get();
//        assertEquals(department.getDepartmentName(),"ABZ");
//    }
//}