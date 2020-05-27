package parking;

import parking.prototype.VehicleCache;

public class Application {

    public static void main(String[] args) throws CloneNotSupportedException {

        VehicleCache.loadCache(); // Instantiate some vehicles and clones them in the vehicle Collection (Map, List etc)
        System.out.println(VehicleCache.getVehicle("0001"));
        System.out.println(VehicleCache.getVehicle("0002"));
        System.out.println(VehicleCache.getVehicle("0003"));
        System.out.println(VehicleCache.getVehicle("0004"));
    }
}
