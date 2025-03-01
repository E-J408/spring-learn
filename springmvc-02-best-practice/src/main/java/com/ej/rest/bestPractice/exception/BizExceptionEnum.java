package com.ej.rest.bestPractice.exception;

public enum BizExceptionEnum {

    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器内部错误"),
    PARAM_ERROR(400, "参数错误"),
    UNKNOWN_ERROR(1000, "未知错误"),
    ID_NULL_ERROR(1001, "id不能为空"),
    ;

    private Integer code;
    private String msg;

    BizExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
