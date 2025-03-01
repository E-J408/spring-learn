package com.ej.rest.crud.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.ej.rest.crud.bean.Employee;
import com.ej.rest.crud.dao.EmployeeDao;
import com.ej.rest.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        // null处理
        // 如果传来的id是null，不做事
        if (employee.getId() == null)
            return;
        Integer id = employee.getId();
        // 查询出原来的值
        Employee oldEmployeeInfo = employeeDao.getEmployeeById(id);
        // 把页面带来的值覆盖掉原来的值，如果为空则保留旧值
        if(StringUtil.isNullOrEmpty(employee.getName()))
            employee.setName(oldEmployeeInfo.getName());
        if(StringUtil.isNullOrEmpty(employee.getEmail()))
            employee.setEmail(oldEmployeeInfo.getEmail());
        if(StringUtil.isNullOrEmpty(employee.getGender()))
            employee.setGender(oldEmployeeInfo.getGender());
        if(StringUtil.isNullOrEmpty(employee.getAddress()))
            employee.setAddress(oldEmployeeInfo.getAddress());
        if(employee.getSalary() == null)
            employee.setSalary(oldEmployeeInfo.getSalary());
        if(employee.getAge() == null)
            employee.setAge(oldEmployeeInfo.getAge());
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
}
