package com.ej.rest.crud.dao;

import com.ej.rest.crud.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    /*
    * 查询员工
    * */
    Employee getEmployeeById(Integer id);

    /*
    * 新增员工
    * */
    void addEmployee(Employee employee);

    /*
    * 修改员工
    * */
    void updateEmployee(Employee employee);

    /*
    * 删除员工
    * */
    void deleteEmployeeById(Integer id);

    /*
    * 查询所有员工，返回员工的list
    * */
    List<Employee> getAllEmployee();
}
