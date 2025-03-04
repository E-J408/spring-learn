package com.ej.rest.bestPractice.vo.req;

import com.ej.rest.bestPractice.annotation.Gender;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

/**
 * @program: ssm-parent
 * @description: 封装添加Employee的请求的vo
 * @author: EJ_Zheng
 * @create: 2025-03-03 17:41
 **/

public class EmployeeAddVo {
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String Name;

    @NotNull
    @Max(value = 120, message = "年龄不能大于120岁")
    @Min(value = 1, message = "年龄不能小于1岁")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Gender(message = "{gender.message}")
    private String gender;
    private String address;
    private BigDecimal salary;


    public EmployeeAddVo() {
    }

    public EmployeeAddVo(Integer id, String Name, Integer age, String email, String gender, String address, BigDecimal salary) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.salary = salary;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 设置
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String toString() {
        return "EmployeeAddVo{id = " + id + ", Name = " + Name + ", age = " + age + ", email = " + email + ", gender = " + gender + ", address = " + address + ", salary = " + salary + "}";
    }
}
