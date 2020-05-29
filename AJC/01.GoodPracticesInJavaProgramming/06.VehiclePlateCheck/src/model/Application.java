package model;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        RegisteredCar rCar1= new RegisteredCar("Audi", "1234");
        RegisteredCar rCar2 = new RegisteredCar("Audi", "1234");

        System.out.println("Equals: " +(rCar1 == rCar2));
        System.out.println(".equals: " + rCar1.equals(rCar2));

        RegisteredTruck rTruck1= new RegisteredTruck("Man", "1234");
        RegisteredTruck rTruck2 = new RegisteredTruck("Man", "1234");

        System.out.println("Equals: " +(rTruck1 == rTruck2));
        System.out.println(".equals: " +rTruck1.equals(rTruck2));
    }
}
