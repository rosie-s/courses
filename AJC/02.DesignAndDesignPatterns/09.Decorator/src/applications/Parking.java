package applications;

import model.parking.UnregisteredCar;
import pattern.decorator.TrailSize;
import pattern.decorator.UnregisteredCustomCar;
import pattern.decorator.UnregisteredTrailedCar;
import pattern.prototype.VehicleCache;

public class Parking {

    public static void main(String[] args) throws CloneNotSupportedException {

//        VehicleCache.loadCache(); // Instantiate some vehicles and clones them in the vehicle Collection (Map, List etc)
//        System.out.println(VehicleCache.getVehicle("0001"));
//        System.out.println(VehicleCache.getVehicle("0002"));
//        System.out.println(VehicleCache.getVehicle("0003"));
//        System.out.println(VehicleCache.getVehicle("0004"));
//        System.out.println(VehicleCache.getVehicle("0005"));

        // Decorator
        UnregisteredCustomCar unregisteredCustomCar = new UnregisteredCustomCar
                (new UnregisteredCar("Toyota", "12345"), 1, "Extra fees");

        UnregisteredTrailedCar unregisteredTrailedCar = new UnregisteredTrailedCar(
                new UnregisteredCar("Ford", "56432"), TrailSize.MEDIUM);

        System.out.println("Unregistered Custom Car: " + unregisteredCustomCar);
        System.out.println("Get toll gate price: " + unregisteredCustomCar.getTollGatePrice());
        System.out.println("Unregistered Trailed Car: " + unregisteredTrailedCar.trailSize);
        System.out.println("Get toll gate price: " + unregisteredTrailedCar.getTollGatePrice());

    }

}
