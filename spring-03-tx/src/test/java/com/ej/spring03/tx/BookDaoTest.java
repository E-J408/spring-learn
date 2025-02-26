package com.ej.spring03.tx;

import com.ej.spring03.tx.Dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    void testQuery(){
        BigDecimal price = bookDao.getBookPriceById(1);
        System.out.println(price);
    }

}
