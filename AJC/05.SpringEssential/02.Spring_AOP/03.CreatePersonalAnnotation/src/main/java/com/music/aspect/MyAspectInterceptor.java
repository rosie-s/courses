package com.music.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectInterceptor {

    @Pointcut("execution(* *.play(..))")
    public void intercept(){}

    @Before("intercept()")
    public void interceptToString() {
        System.out.println("Before playing: 0/10");
    }

    @AfterReturning(pointcut = "intercept()", returning = "result")
    public void interceptorToStringReturning(int result) {
        result = 9;
        System.out.println("After playing: " + result + "/10");
    }
}
