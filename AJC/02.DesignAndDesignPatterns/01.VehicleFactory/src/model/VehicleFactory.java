package model;

public class VehicleFactory {

    public Vehicle createVehicle(VehicleType type, String brand, String plate) {

        Vehicle returnType = null;

        if (type.equals(VehicleType.UNREGISTEREDCAR)) {
            returnType = new UnregisteredCar(brand, plate);
            System.out.println("Unregistered Car - " + brand + " created with plate: " + plate + ".");
        }
        if (type.equals(VehicleType.UNREGISTEREDTRUCK)) {
            returnType = new UnregisteredTruck(brand, plate);
            System.out.println("Unregistered Truck - " + brand + " created with plate: " + plate + ".");
        }
        if (type.equals(VehicleType.REGISTEREDCAR)) {
            returnType = new RegisteredCar(brand, plate);
            System.out.println("Registered Car - " + brand + " created with plate: " + plate + ".");
        }
        if (type.equals(VehicleType.REGISTEREDTRUCK)) {
            returnType = new RegisteredTruck(brand, plate);
            System.out.println("Registered Truck - " + brand + " created with plate: " + plate + ".");

        }
        return returnType;
    }

    public enum VehicleType {
        UNREGISTEREDCAR, UNREGISTEREDTRUCK, REGISTEREDCAR, REGISTEREDTRUCK
    }
}
