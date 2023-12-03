package com.example.masterclass.controller;

import com.example.masterclass.entity.Department;
import com.example.masterclass.error.DepartmentNotFoundException;
import com.example.masterclass.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;
    @BeforeEach
    void setUp() {
        department =
                Department.builder()
                        .departmentName("ABZ")
                        .departmentCode("666")
                        .departmentAddress("Gampaha")
                        .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment =
                Department.builder()
                        .departmentName("ABZ")
                        .departmentCode("666")
                        .departmentAddress("Gampaha")
                        .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"ABZ\",\n" +
                        "    \"departmentAddress\": \"Gampaha\",\n" +
                        "    \"departmentCode\": \"666\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDepartment() throws Exception {
        Mockito.when(departmentService.fetchDepartment(1L))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}