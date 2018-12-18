package com.learnsystem.utils;

import com.learnsystem.common.Constant;
import com.learnsystem.common.Result;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
@Aspect
public class WebControllerAop {
    @Pointcut("execution(* com.learnsystem.controller..*.*(..))")
    public void executeService() {
    }

    @Around("executeService()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException, SecurityException {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        Method realMethod = proceedingJoinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());
        LoginNeed[] loginNeeds = realMethod.getAnnotationsByType(LoginNeed.class);
        boolean needLogin = false;
        if(loginNeeds!=null&&loginNeeds.length>0) {
            needLogin = true;
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        Object user = request.getSession().getAttribute(Constant.SESSION_LOGIN_TEACHER);
        if(user==null){
            user = request.getSession().getAttribute(Constant.SESSION_LOGIN_MANAGER);
        }
        if(user==null){
            user = request.getSession().getAttribute(Constant.SESSION_LOGIN_STUDENT);
        }
        boolean logined = user!=null;
        try {
            if(needLogin&&!logined) {//调用需要登录的方法，但是没登录
                System.out.println("用户没有登录。。");
                return new Result(Result.LOGIN_FAIL,"您未登录");
            }else {
                Object obj = proceedingJoinPoint.proceed();
                return obj;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return new Result(Result.LOGIN_FAIL, "系统出现异常");
        }
    }
}
