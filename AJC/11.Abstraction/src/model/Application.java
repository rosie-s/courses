package model;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // Car
        VehicleFactory car = VehicleFactory.getFactory(VehicleFactory.VehicleType.CAR);
        car.createRegisteredVehicle("Toyota", "0001");
        car.createUnregisteredVehicle("Ferrari", "0002");

        // Truck
        VehicleFactory truck = VehicleFactory.getFactory(VehicleFactory.VehicleType.TRUCK);
        truck.createRegisteredVehicle("Man", "0003");
        truck.createUnregisteredVehicle("Ram", "0004");

    }
}
