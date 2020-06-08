package com.music;


import com.music.musicians.IntfMusician;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        Scanner scanner = new Scanner(System.in);
        IntfMusician musician = null;
        System.out.println("Who should play? Guitarist (g) or  Pianist (p)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("p")) {
            musician = (IntfMusician) myContext.getBean("pianist");
        } else if (answer.equalsIgnoreCase("g")) {
            musician = (IntfMusician) myContext.getBean("guitarist");
        } else {
            System.out.printf("No");
            return;
        }
        musician.play();
    }
}