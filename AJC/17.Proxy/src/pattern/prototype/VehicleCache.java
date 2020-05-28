package pattern.prototype;

import model.parking.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class VehicleCache {


    private static Hashtable<java.lang.String, Vehicle> vehicleHashtable = new Hashtable<>(); // thread safe

    public static Vehicle getVehicle(String plate) {
        return vehicleHashtable.get(plate);
    }

    public static void loadCache() throws CloneNotSupportedException{
        System.out.println("Loading data from DB");

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add (new UnregisteredCar("Toyota", "0001"));
        vehicleList.add(new RegisteredCar("Ford", "0002"));
        vehicleList.add(new UnregisteredTruck("Man", "0003"));
        vehicleList.add(new RegisteredTruck("Ram", "0004"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded vehicles");

        for (Vehicle v: vehicleList){
            VehicleCache.vehicleHashtable.put(v.plate, (Vehicle) v.clone());
        }
    }

}
