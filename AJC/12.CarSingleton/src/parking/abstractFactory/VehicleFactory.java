package parking.abstractFactory;

import parking.model.Vehicle;

public abstract class VehicleFactory {

    public abstract Vehicle createRegisteredVehicle(String brand, String plate);
    public abstract Vehicle createUnregisteredVehicle(String brand, String plate);

    public static VehicleFactory getFactory(VehicleType type) {
        if (type.equals(VehicleType.CAR)) {
            System.out.println("**Car Factory**");
            return new CarFactory();
        } else {
            System.out.println("**Truck Factory**");
            return new TruckFactory();
        }
    }
}
