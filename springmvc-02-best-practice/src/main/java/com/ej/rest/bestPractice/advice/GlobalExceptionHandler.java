package com.ej.rest.bestPractice.advice;


import com.ej.rest.bestPractice.common.R;
import com.ej.rest.bestPractice.exception.BizException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ssm-parent
 * @description: 专门进行全局异常处理
 * @author: EJ_Zheng
 * @create: 2025-03-01 16:05
 **/


@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @description: 拦截业务逻辑异常
    * @Param: [e]
    * @return: com.ej.rest.bestPractice.common.R
    */
    @ExceptionHandler(BizException.class)
    public R bizExceptionHandler(BizException e) {
        e.printStackTrace();
        return R.error(e.getCode(),e.getMsg());
    }

    /**
     * @description: 拦截参数校验异常
    * @Param: [e]
    * @return: com.ej.rest.bestPractice.common.R
    */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> errorsMap = new HashMap<>();
        for(FieldError fieldError: result.getFieldErrors())
        {
            errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return R.error(400,"数据校验异常", errorsMap);
    }
    @ExceptionHandler(Throwable.class)
    public R exceptionHandler(Throwable e) {
        e.printStackTrace();
        return R.error(500,e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        e.printStackTrace();
        return R.error(500,e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public R exceptionHandler(ArithmeticException e) {
        e.printStackTrace();
        return R.error(300,e.getMessage());
    }


}
