package parking;

import parking.abstractFactory.VehicleFactory;
import parking.abstractFactory.VehicleType;
import parking.singleton.CarSingleton;

public class Application {

    public static void main(String[] args) {
        // Car
        VehicleFactory car = VehicleFactory.getFactory(VehicleType.CAR);
        car.createRegisteredVehicle("Toyota", "0001");
        car.createUnregisteredVehicle("Ferrari", "0002");

        // Truck
        VehicleFactory truck = VehicleFactory.getFactory(VehicleType.TRUCK);
        truck.createRegisteredVehicle("Man", "0003");
        truck.createUnregisteredVehicle("Ram", "0004");

        // Singleton
        CarSingleton c1 = CarSingleton.getInstance();
        CarSingleton c2 = CarSingleton.getInstance();
        System.out.println("\nShould be true: " + (c1 == c2));

    }
}
