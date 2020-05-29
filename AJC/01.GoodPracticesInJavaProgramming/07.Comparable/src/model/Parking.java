package model;

import java.util.ArrayList;
import java.util.List;

public class Parking<T> implements Comparable<Parking> {
    private String code;
    public String name;
    public int capacity = 15;
    List<T> vehicleList;
    public List<TollGate> tollGates = new ArrayList<>();

    public Parking(String name, String code, int capacity) {
        this.name = name;
        this.code = code;
        this.capacity = capacity;
        this.vehicleList = new ArrayList<>();

        this.tollGates.add(new TollGate(Orientation.WEST, Direction.IN));
        this.tollGates.add(new TollGate(Orientation.EAST, Direction.OUT));

    }

    public void add(T vehicle) {
        this.vehicleList.add(vehicle);
    }

    public List<T> getVehicleList() {
        return vehicleList;
    }

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


    public class TollGate {
        public String id;

        boolean enable = true;
        Orientation orientation;
        Direction direction;

        public TollGate(Orientation orientation, Direction direction) {
            this.id = Parking.this.code.toUpperCase() + "#door-" + Parking.this.tollGates.size();
            this.orientation = orientation;
            this.direction = direction;
        }
    }

    private enum Orientation {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    private enum Direction {
        IN,
        OUT,
        INOUT
    }

    @Override
    public int compareTo(Parking p) {
        if (this.getVehicleList().size() < p.getVehicleList().size())
            return 1;
        else if (this.getVehicleList().size() > p.getVehicleList().size())
            return -1;
        return 0;

    }

}
