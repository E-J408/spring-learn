package com.ej.spring03.tx.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 按照userName扣减账户余额
    public Boolean updateAccountBalanceByUsername(String username, BigDecimal price) {
        String sql = "update account set balance = balance - ? where username = ?";
        return jdbcTemplate.update(sql, price, username) > 0;
    }
}
