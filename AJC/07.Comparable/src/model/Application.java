package model;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        Parking<Car> carParking = new Parking("Car", "JJC", 04);
        Parking<Truck> truckParking = new Parking("Truck", "JJT", 05);
        Parking allParking = new Parking("Public", "JJA", 10);


        // Car
        carParking.add(new UnregisteredCar("Ferrari", "0001"));
        carParking.add(new UnregisteredCar("Toyota", "0002"));
        carParking.add(new RegisteredCar("Ford", "0003"));

        // Truck
        truckParking.add(new UnregisteredTruck("Tesla", "0004"));
        truckParking.add(new RegisteredTruck("Man", "0005"));

        // All
        allParking.add(new UnregisteredCar("Renault", "0006"));
        allParking.add(new RegisteredCar("Bentley", "0007"));
        allParking.add(new RegisteredCar("Lamborghini", "0008"));
        allParking.add(new RegisteredTruck("Jeep", "0009"));

        List<Parking> parking = Arrays.asList(carParking, truckParking, allParking);

        System.out.println("Default Order: ");
        Collections.sort(parking);
        for (Parking p : parking) {
            System.out.println(p.name);
        }
        System.out.println("\nSorting using Collections.sort");
        Collections.sort(parking, new ParkingSizeComparator());
        for (Parking p : parking) {
            System.out.println(p.name + " - " + p.vehicleList.size());
        }

        System.out.println("\nSorting using Comparator: ");
        Collections.sort(parking, new Comparator<Parking>() {
            @Override
            public int compare(Parking o1, Parking o2) {
                if (o1.calculateTotalPrice() > o2.calculateTotalPrice())
                    return 1;
                else if (o1.calculateTotalPrice() < o2.calculateTotalPrice())
                    return -1;
                return 0;
            }
        });
        for (Parking p : parking) {
            System.out.println(p.name + " - " + p.calculateTotalPrice() + "EUR");
        }
        
    }
}
