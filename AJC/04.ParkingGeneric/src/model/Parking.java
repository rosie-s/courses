package model;

import java.util.ArrayList;
import java.util.List;

public class Parking <T> {
    private String code;
    public String name;
    List<T> vehicleList;

    public double calculateTotalPrice() {
        Double price = 0.0;
        for (T v : vehicleList) {
            if (v instanceof UnregisteredCar) {
                price += ((UnregisteredCar) v).payTollGate();
            } else if (v instanceof UnregisteredTruck) {
                price += ((UnregisteredTruck) v).payTollGate();
            }
        }
        return price;
    }

    public List<T> getVehicleList() {
        return vehicleList;
    }

    public void add(T vehicle) {
        this.vehicleList.add(vehicle);

    }

    public Parking(String name, String code) {
        this.name = name;
        this.code = code;
        this.vehicleList = new ArrayList<>();
    }



}
