package com.ej.spring03.tx.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Integer id;
    private String username;
    private Integer age;
    private BigDecimal balance;
}
