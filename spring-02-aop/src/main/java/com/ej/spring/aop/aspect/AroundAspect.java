package com.ej.spring.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {
    /*
    * 环绕通知的固定写法：
    * Object：返回值
    * ProceedingJoinPoint：可以继续推进的连接点
    * */

    @Pointcut("execution(int com.ej.spring.aop.calculator.MathCalculator.*(int,int))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();
        // 可以修改参数
        System.out.println("【切面-环绕】目标方法执行前");
        Object result = null;
        try {
            result = joinPoint.proceed(args); // 继续执行目标方法，相当于method.invoke()
            System.out.println("【切面-环绕】目标方法执行返回");
        }
        catch (Exception e)
        {
            System.out.println("【切面-环绕】目标方法执行异常");
        }
        finally {
            System.out.println("【切面-环绕】目标方法执行后");
        }
        return result;

    }
}
