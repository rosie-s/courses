package com.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Entry {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
    }
}
