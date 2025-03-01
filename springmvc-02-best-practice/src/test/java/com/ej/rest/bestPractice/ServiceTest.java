package com.ej.rest.bestPractice;

import com.ej.rest.bestPractice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    public void testGetAllEmployee() {
        System.out.println(employeeService.getAllEmployee());
    }
}
