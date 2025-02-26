package com.ej.spring03.tx.Dao;


import com.ej.spring03.tx.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Book getBookById(Integer id) {
        String sql = "select * from book where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }
    public Boolean insertNewBook(Book book) {
        String sql = "insert into book(bookName,price,stock) values(?,?,?)";
        return jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock()) > 0;
    }
    // 按照id修改图书库存
    public Boolean updateBookStockById(Integer id, Integer stock) {
        String sql = "update book set stock = ? where id = ?";
        return jdbcTemplate.update(sql, stock, id) > 0;
    }

    // 按照id删除图书
    public Boolean deleteBookById(Integer id) {
        String sql = "delete from book where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    // 按照id读取价格
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public BigDecimal getBookPriceById(Integer id) {
        String sql = "select price from book where id = ?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
    }

}
