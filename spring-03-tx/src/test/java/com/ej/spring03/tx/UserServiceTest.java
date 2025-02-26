package com.ej.spring03.tx;

import com.ej.spring03.tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    void testCheckout() throws InterruptedException {
        userService.checkout("zhangsan", 1,3);

    }
}
