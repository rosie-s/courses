package model;

import java.util.ArrayList;
import java.util.List;

public class Parking<T> {
    private String code;
    public String name;
    List<T> vehicleList;
    public List<TollGate> tollGates = new ArrayList<>();

    public Parking(String name, String code) {
        this.name = name;
        this.code = code;
        this.vehicleList = new ArrayList<>();

        // Toll gate in
        String tollGatesInID = code + "#" + "door-" + this.tollGates.size();
        TollGate tollGateIn = new TollGate(tollGatesInID, true, Orientation.WEST, Direction.IN);
        tollGates.add(tollGateIn);

        //Toll gate out
        String tollGatesOutID = code + "#" + "door-" + this.tollGates.size();
        TollGate tollGateOut = new TollGate(tollGatesOutID, true, Orientation.EAST, Direction.OUT);
        tollGates.add(tollGateOut);

        System.out.println("Jean Jaures " + name+ " gates");
        for (TollGate tollGate : tollGates) {
            System.out.println("--Gate: " + tollGate.id);
        }
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
        public boolean enable = true;
        private Orientation orientation;
        private Direction direction;

        public TollGate(String id, boolean enable, Orientation orientation, Direction direction) {
            this.id = id;
            this.enable = enable;
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
}
