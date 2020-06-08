package com.music;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");


        System.out.println("By name");
        IntfMusician myMusician = (IntfMusician) myContext.getBean("guitarist");
        myMusician.play();

        System.out.println("By Interface");
        myMusician = myContext.getBean(IntfMusician.class);
        myMusician.play();

        System.out.println("By Both");
        myMusician = myContext.getBean("guitarist", IntfMusician.class);
        myMusician.play();

    }
}