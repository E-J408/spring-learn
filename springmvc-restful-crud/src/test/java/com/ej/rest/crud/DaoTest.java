package com.ej.rest.crud;

import com.ej.rest.crud.bean.Employee;
import com.ej.rest.crud.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class DaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testGetEmployeeById() {

        System.out.println(employeeDao.getEmployeeById(5));
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setName("EJ");
        employee.setAge(18);
        employee.setEmail("EJ@163.com");
        employee.setGender("男");
        employee.setAddress("北京");
        employee.setSalary(new BigDecimal(10000));
        employeeDao.addEmployee(employee);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("EJ");
        employee.setAge(18);
        employee.setEmail("EJ@163.com");
        employee.setGender("男");
        employee.setAddress("北京");
        employee.setSalary(new BigDecimal(20000));
        employeeDao.updateEmployee(employee);
    }

    @Test
    public void testDeleteEmployeeById() {
        employeeDao.deleteEmployeeById(1);
    }

    @Test
    public void testGetAllEmployee() {
        System.out.println(employeeDao.getAllEmployee());
    }
}
