package com.ej.rest.bestPractice.advice;


import com.ej.rest.bestPractice.common.R;
import com.ej.rest.bestPractice.exception.BizException;
import org.springframework.web.bind.annotation.*;

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
