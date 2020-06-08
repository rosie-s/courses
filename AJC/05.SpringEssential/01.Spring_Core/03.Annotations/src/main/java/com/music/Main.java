package com.music;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        IntfMusician myMusician2 = (IntfMusician) myContext.getBean(IntfMusician.class);
        myMusician2.play();

        myContext.close();
    }
}