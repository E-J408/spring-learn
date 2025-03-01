package com.ej.rest.crud.bean;

import lombok.Data;

import java.math.BigDecimal;


public class Employee {
    private Integer id;
    private String Name;
    private Integer age;
    private String email;
    private String gender;
    private String address;
    private BigDecimal salary;


    public Employee() {
    }

    public Employee(Integer id, String Name, Integer age, String email, String gender, String address, BigDecimal salary) {
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
        return "Employee{id = " + id + ", Name = " + Name + ", age = " + age + ", email = " + email + ", gender = " + gender + ", address = " + address + ", salary = " + salary + "}";
    }
}
