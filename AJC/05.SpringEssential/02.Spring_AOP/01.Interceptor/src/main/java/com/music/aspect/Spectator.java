package com.music.aspect;

public class Spectator {
    public void  interceptorToStringReturning(String result){
        System.out.println("Instrument playing");

    }
    public void interceptToString(){
        System.out.println("Intercepting");
    }

}
