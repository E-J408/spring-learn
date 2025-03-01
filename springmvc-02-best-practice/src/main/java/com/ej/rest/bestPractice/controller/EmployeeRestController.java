package com.ej.rest.bestPractice.controller;


import com.ej.rest.bestPractice.bean.Employee;
import com.ej.rest.bestPractice.common.R;
import com.ej.rest.bestPractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    /*
    * 规定返回值
    * code: 业务的状态码，200是成功，剩下都是失败；前后端将来会一起商定不同的业务状态码
    * msg: 业务的状态信息，用来提示用户
    * data: 业务返回的数据
    *
    * 示例：
    * {
    *     "code": 200,
    *     “msg": "操作成功",
    *     "data": null
    * }
    * */

    /**
     * 根据id获取员工信息
    * @Param: [id]
    * @return: com.ej.rest.crud.bean.Employee
    */
    @GetMapping("/employee/{id}")
    public R<Employee> get(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return R.ok(employee);
    }

    /**
     * 添加员工信息
     *
     * @Param: [employee]
     * @return: R
     */
    @PostMapping("/employee")
    public R add(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return R.ok();

    }

    /**
     * 更新员工信息
    * @Param: [employee]
    * @return: void
    */
    @PutMapping("/employee")
    public R update(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return R.ok();
    }

    /**
     * 删除员工信息
    * @Param: [id]
    * @return: void
    */
    @DeleteMapping("/employee/{id}")
    public R delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeById(id);
        return R.ok();
    }

    /**
     * 获取所有员工信息
    * @Param: []
    * @return: java.util.List<com.ej.rest.crud.bean.Employee>
    */
    @GetMapping("/employees")
    public R<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAllEmployee();
        return R.ok(employees);
    }


}
