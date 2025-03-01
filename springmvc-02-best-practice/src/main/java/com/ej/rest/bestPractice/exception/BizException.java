package com.ej.rest.bestPractice.exception;

/**
 * @program: ssm-parent
 * @description: 自己定义的业务异常
 * @author: EJ_Zheng
 * @create: 2025-03-01 16:20
 **/

public class BizException extends RuntimeException{
    private Integer code;
    private String msg;


    public BizException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @description: 通过枚举类对象直接构建异常
    * @Param: [bizExceptionEnum]
    * @return:
    */
    public BizException(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.msg = bizExceptionEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
