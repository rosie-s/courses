package pattern.factory;

import parking.model.RegisteredCar;
import parking.model.UnregisteredCar;
import parking.model.Vehicle;

public class CarFactory extends VehicleFactory {

    @Override
    public Vehicle createRegisteredVehicle(String brand, String plate) {
        System.out.println("Registered " + brand + " with plate : " + plate + ".");
        return new RegisteredCar(brand, plate);
    }

    @Override
    public Vehicle createUnregisteredVehicle(String brand, String plate) {
        System.out.println("Unregistered " + brand + " with plate : " + plate + ".");
        return new UnregisteredCar(brand, plate);
    }
}
