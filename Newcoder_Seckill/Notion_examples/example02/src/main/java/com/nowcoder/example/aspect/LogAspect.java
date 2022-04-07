package com.nowcoder.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.nowcoder.example.service.*.*(..))")
    private void serviceAccess() {

    }

//    @Before("serviceAccess()")
    public void before() {
        System.out.println("log before");
    }

//    @AfterThrowing("serviceAccess()")
    public void afterThrowing() {
        System.out.println("log afterThrowing");
    }

//    @AfterReturning("serviceAccess()")
    public void afterReturning() {
        System.out.println("log afterReturning");
    }

//    @After("serviceAccess()")
    public void after() {
        System.out.println("log after");
    }

    @Around("serviceAccess()")
    public Object log(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            System.out.println("log before");
            // 调用目标组件的方法
            obj = joinPoint.proceed();
            System.out.println("log afterReturning");
        } catch (Throwable throwable) {
            System.out.println("log afterThrowing");
        } finally {
            System.out.println("log after");
        }

        return obj;
    }

}
