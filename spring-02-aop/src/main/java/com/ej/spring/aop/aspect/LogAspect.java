package com.ej.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    /*
    * 告诉Spring：以下通知何时何地运行？
    * 何时？
    *   @Before 方法执行之前
    *   @AfterReturning 方法执行正常结果返回之后
    *   @AfterThrowing  方法执行异常返回之后
    *   @After  方法执行之后
    * 何地？
    *   切入点表达式：
    *   execution(方法的全签名)
    *       省略写法：返回类型 + （全类）方法名 + 参数列表
    * */
    // 切入点抽取
    @Pointcut("execution(int com.ej.spring.aop.calculator.MathCalculator.*(int,int))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        // 1. 拿到方法全签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        // 方法名
        String methodName = methodSignature.getName();
        // 目标方法传来的参数值
        Object[] args = joinPoint.getArgs();
        System.out.println("【切面-日志】【"+methodName+"】开始...参数列表" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("【切面-日志】结束...");
    }
    @AfterThrowing(value = "pointCut()"
                    ,throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("【切面-日志】【"+ methodName +"】异常... 异常信息" + e.getMessage());
    }
    @AfterReturning(value = "pointCut()",
                    returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("【切面-日志】【"+ methodName +"】返回结果... 结果" + result);
    }
}
