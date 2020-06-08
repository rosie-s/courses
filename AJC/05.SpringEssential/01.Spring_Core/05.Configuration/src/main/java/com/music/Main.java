package com.music;


import com.music.config.AppConfig;
import com.music.musicians.IntfMusician;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner = new Scanner(System.in);
        IntfMusician musician = null;
        System.out.println("Who should play? Guitarist (g) or  Pianist (p)");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("p")) {
            musician = (IntfMusician) context.getBean("pianist");
        } else if (answer.equalsIgnoreCase("g")) {
            musician = (IntfMusician) context.getBean("guitarist");
        } else {
            System.out.printf("No");
            return;
        }
        musician.play();
        context.close();
    }
}