package com.ej.spring03.tx;

import com.ej.spring03.tx.Dao.AccountDao;
import com.ej.spring03.tx.Dao.BookDao;
import com.ej.spring03.tx.bean.Account;
import com.ej.spring03.tx.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring03TxApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;
    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    void testQuery() {
        System.out.println(bookDao.getBookById(1));
    }

    @Test
    void testAddBook() {
        Book b = new Book();
        b.setBookName("剑指redis");
        b.setPrice(new BigDecimal(99.9));
        b.setStock(100);
        if (bookDao.insertNewBook(b))
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
    }

    @Test
    void testUpdateBookStock() {
        if (bookDao.updateBookStockById(1, 200))
            System.out.println("更新成功");
        else
            System.out.println("更新失败");
    }

    @Test
    void testDeleteBook() {
        if (bookDao.deleteBookById(4))
            System.out.println("删除成功");
        else
            System.out.println("删除失败");
    }

    @Test
    void testUpdateBalance() {
        accountDao.updateAccountBalanceByUsername("zhangsan", new BigDecimal("9.9"));
    }
}
