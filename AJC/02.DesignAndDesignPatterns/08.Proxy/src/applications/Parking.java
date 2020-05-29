package applications;

import pattern.prototype.VehicleCache;

public class Parking {

    public static void main(String[] args) throws CloneNotSupportedException {

        VehicleCache.loadCache(); // Instantiate some vehicles and clones them in the vehicle Collection (Map, List etc)
        System.out.println(VehicleCache.getVehicle("0001"));
        System.out.println(VehicleCache.getVehicle("0002"));
        System.out.println(VehicleCache.getVehicle("0003"));
        System.out.println(VehicleCache.getVehicle("0004"));
        System.out.println(VehicleCache.getVehicle("0005"));
    }
}
