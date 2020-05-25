package model;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String code;
    public String name;
    List<Vehicle> vehicleList;

    public double calculateTotalPrice() {
        Double price = 0.0;
        for (Vehicle v : vehicleList) {
            if (v instanceof UnregisteredCar) {
                price += ((UnregisteredCar) v).payTollGate();
            } else if (v instanceof UnregisteredTruck) {
                price += ((UnregisteredTruck) v).payTollGate();
            }
        }
        return price;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void add(Vehicle vehicle) {
        this.vehicleList.add(vehicle);

    }

    public Parking(String name, String code) {
        this.name = name;
        this.code = code;
        this.vehicleList = new ArrayList<>();
    }



}
