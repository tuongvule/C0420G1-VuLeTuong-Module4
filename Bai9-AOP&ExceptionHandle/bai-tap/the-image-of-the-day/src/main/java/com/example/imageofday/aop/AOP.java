package com.example.imageofday.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AOP {
    @AfterReturning("execution(public * com.example.imageofday.service.CommentServiceImpl.*(..))")
    public void showError(JoinPoint joinPoint){
        System.out.println("Done");
    }
    @AfterThrowing(value = "execution(public * com.example.imageofday.controller.CommentController.addNewComment(..))", throwing = "e")
    public void show(JoinPoint joinPoint,Exception e){
        String className = joinPoint.getTarget().getClass().getName();
        String method =joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Hê thống có lỗi xảy ra: %s.%s%s: %s",className,method,args,e.getMessage()));
    }
}
