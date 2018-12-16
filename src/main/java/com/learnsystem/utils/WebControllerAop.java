package com.learnsystem.utils;

import com.learnsystem.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WebControllerAop {
//    @Pointcut("execution(* com.learnsystem.controller.*..*.*(..))")
    @Pointcut("execution(* com.learnsystem.controller..*.*(..))")
    public void executeService() {
    }

    @Around("executeService()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException, SecurityException {
        try {
            System.out.println(666);
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return new Result(Result.LOGIN_FAIL, "系统出现异常");
        }
    }
}
