package com.ej.spring.aop.calculator.impl;

import com.ej.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

@Component
public class MathCalculatorImpl implements MathCalculator {


    @Override
    public int add(int a, int b) {
        int result = a+b;
        System.out.println("结果："+result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a-b;
        System.out.println("结果："+ result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a*b;
        System.out.println("结果："+ result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a /b;
        System.out.println("结果："+ result);
        return result;
    }
}
