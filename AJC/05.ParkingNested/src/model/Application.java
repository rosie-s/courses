package model;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        // Make previous exercise generic
        Parking<Car> carParking = new Parking("Car", "JJC");
        Parking<Truck> truckParking = new Parking("Truck", "JJT");
        Parking allParking = new Parking("Public", "JJA");

        carParking.add(new RegisteredCar("Toyota"));
        allParking.add(new RegisteredCar("Toyota"));

        carParking.add(new RegisteredCar("Audi"));
        allParking.add(new RegisteredCar("Audi"));

        carParking.add(new UnregisteredCar("Ferrari"));
        allParking.add(new UnregisteredCar("Ferrari"));

        carParking.add(new UnregisteredCar("Renault"));
        allParking.add(new UnregisteredCar("Renault"));

        truckParking.add(new RegisteredTruck("Ford"));
        allParking.add(new RegisteredTruck("Ford"));

        truckParking.add(new RegisteredTruck("Fiat"));
        allParking.add(new RegisteredTruck("Fiat"));

        truckParking.add(new UnregisteredTruck("Tesla"));
        allParking.add(new UnregisteredTruck("Tesla"));

        truckParking.add(new UnregisteredTruck("Porsche"));
        allParking.add(new UnregisteredTruck("Porsche"));

        int carSize = carParking.vehicleList.size();
        int truckSize = carParking.vehicleList.size();

        System.out.println("Parking All: " + allParking.getVehicleList().size());
        System.out.println("Parking Cars: " + carParking.vehicleList.size() );
        System.out.println("Parking Trucks: " + truckParking.vehicleList.size());

        System.out.println(allParking.getVehicleList().size() + " vehicles, Unregistered total cost is: " + allParking.calculateTotalPrice() + "EUR");
        
    }
}
