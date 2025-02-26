package com.ej.spring.aop;

import com.ej.spring.aop.calculator.MathCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {

    @Autowired
    MathCalculator mathCalculator;

    @Test
    void test01() {
        mathCalculator.div(1, 1);

        mathCalculator.div(1, 0);
    }
}
