package com.ej.spring.aop.log;

import java.util.Arrays;

public class LogUtils {

    public static void logStart(String name, Object... args) {
        System.out.println("【日志】：【"+ name +"】开始 参数"+ Arrays.toString(args));
    }
}
