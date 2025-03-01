package com.ej.rest.bestPractice.dao.impl;

import com.ej.rest.bestPractice.bean.Employee;
import com.ej.rest.bestPractice.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Employee getEmployeeById(Integer id) {
        String sql = "select * from employee where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into employee(name,age,email,gender,address,salary) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getEmail(), employee.getGender(),
                employee.getAddress(), employee.getSalary());

    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "update employee set name = ?,age = ?,email = ?,gender = ?,address = ?,salary = ? where id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getAge(), employee.getEmail(), employee.getGender(),
                employee.getAddress(), employee.getSalary(), employee.getId());

    }

    @Override
    public void deleteEmployeeById(Integer id) {
        String sql = "delete from employee where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
}
