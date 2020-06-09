package com.app;

import com.app.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Entry {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        AnnotationConfigApplicationContext contextAnnotation = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
