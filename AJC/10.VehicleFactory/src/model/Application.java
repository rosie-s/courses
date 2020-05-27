package model;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        // Use Vehicle Factory
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle registeredCar = vehicleFactory.createVehicle(VehicleFactory.VehicleType.REGISTEREDCAR, "Toyota", "0001");
        Vehicle unRegisteredCar = vehicleFactory.createVehicle(VehicleFactory.VehicleType.UNREGISTEREDCAR, "Fiat", "0002");
        Vehicle registeredTruck = vehicleFactory.createVehicle(VehicleFactory.VehicleType.REGISTEREDTRUCK, "Man", "0003");
        Vehicle unRegisteredTruck = vehicleFactory.createVehicle(VehicleFactory.VehicleType.UNREGISTEREDTRUCK, "Ram", "0004");
    }
}
