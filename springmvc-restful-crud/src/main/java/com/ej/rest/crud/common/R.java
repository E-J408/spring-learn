package com.ej.rest.crud.common;

/**
 * @program: ssm-parent
 * @description: 给前端的通用返回类型
 * @author: EJ_Zheng
 * @create: 2025-02-28 21:34
 **/

public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    /**
     * 提供数据的成功返回
    * @Param: [data]
    * @return: com.ej.rest.crud.common.R<T>
    */
    public static<T> R<T> ok(T data) {
        return new R<>(200, "success", data);
    }
    /**
     * 不用提供数据的返回
    * @Param: []
    * @return: com.ej.rest.crud.common.R
    */
    public static R ok(){
        R tr = new R();
        tr.setCode(200);
        tr.setMsg("success");
        return tr;
    }

    public static R error(){
        R tr = new R();
        tr.setCode(500); // 默认失败码
        tr.setMsg("error");
        return tr;
    }

    public static R error(String msg) {
        R tr = new R();
        tr.setCode(500); // 默认失败码
        tr.setMsg(msg);
        return tr;
    }

    public static R error(Integer code, String msg) {
        R tr = new R();
        tr.setCode(code);
        tr.setMsg(msg);
        return tr;
    }

    public static<T> R<T> error(Integer code, String msg, T data) {
        R<T> tr = new R<>();
        tr.setCode(code);
        tr.setMsg(msg);
        tr.setData(data);
        return tr;
    }

    public R() {
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "R{code = " + code + ", msg = " + msg + ", data = " + data + "}";
    }
}
