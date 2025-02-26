package com.ej.spring03.tx.service.impl;

import com.ej.spring03.tx.Dao.AccountDao;
import com.ej.spring03.tx.Dao.BookDao;
import com.ej.spring03.tx.bean.Book;
import com.ej.spring03.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AccountDao accountDao;
    @Autowired
    BookDao bookDao;

    @Transactional(timeout = 3)
    @Override
    public void checkout(String username, Integer bookId, Integer buyNum) throws InterruptedException {
        // 结账有两件大事，一个是更新余额，一个是更新库存
        // 先查询图书信息
        Book bookBuy = bookDao.getBookById(bookId);
        // 如果库存不足，则返回
        if(bookBuy.getStock() < buyNum)
        {
            System.out.println("库存不足！！");
            return;
        }
        // 计算总金额
        BigDecimal count = bookBuy.getPrice().multiply(BigDecimal.valueOf(buyNum));
        // 直接扣除账户余额
        accountDao.updateAccountBalanceByUsername(username,count);
        Thread.sleep(3000);

        // 2. 更改库存
        bookDao.updateBookStockById(bookId,bookBuy.getStock() - buyNum);



    }
}
