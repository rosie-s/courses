package com.music.aspect;

public class MyAspectInterceptor {

    public void interceptToString() {
        System.out.println("Before playing");
    }

    public void interceptorToStringReturning(int result) {
        result = 5;
        System.out.println("After playing: " + result + "/5");
    }
}
