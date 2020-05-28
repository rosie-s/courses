package pattern.factory;


import model.parking.RegisteredCar;
import model.parking.UnregisteredCar;
import model.parking.Vehicle;

public class TruckFactory extends VehicleFactory {

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
