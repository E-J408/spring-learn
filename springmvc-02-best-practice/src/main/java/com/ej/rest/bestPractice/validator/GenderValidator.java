package com.ej.rest.bestPractice.validator;


import com.ej.rest.bestPractice.annotation.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @program: ssm-parent
 * @description: 性别类的校验器
 * @author: EJ_Zheng
 * @create: 2025-03-03 16:40
 **/

public class GenderValidator implements ConstraintValidator<Gender,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "男".equals(value) || "女".equals(value);
    }
}
