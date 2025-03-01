package com.ej.rest.crud.service;

import com.ej.rest.crud.bean.Employee;

import java.util.List;

public interface EmployeeService {
    /*
    * 使用id查询员工
    * */
    Employee getEmployeeById(Integer id);

    /*
    * 添加员工
    * */
    void addEmployee(Employee employee);

    /*
    * 更新员工
    * */
    void updateEmployee(Employee employee);

    /*
    * 删除员工
    * */
    void deleteEmployeeById(Integer id);

    /*
    * 查询所有员工
    * */
    List<Employee> getAllEmployee();

}
