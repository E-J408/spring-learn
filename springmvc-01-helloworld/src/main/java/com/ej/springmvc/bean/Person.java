package com.ej.springmvc.bean;

import lombok.Data;


@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private Boolean agreement;
    private Address address;
    private String[] hobbies;
    private String sex;

}
