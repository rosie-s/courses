package model.parking;

import java.util.*;

public class Parking<T> implements Comparable<Parking> {
    private String code;
    public String name;
    public int capacity = 15;
    public List<TollGate> tollGates = new ArrayList<>();
    public Set<T> vehicleList = new HashSet<>();
    public Queue<T> waiting = new LinkedList<>();

    public Parking(String name, String code) {
        this.name = name;
        this.code = code;
        this.capacity = capacity;
        this.vehicleList = new HashSet<>();

        this.tollGates.add(new TollGate(Orientation.WEST, Direction.IN));
        this.tollGates.add(new TollGate(Orientation.EAST, Direction.OUT));

    }

    public Set<T> getVehicleList() {
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
        NORTH, EAST, SOUTH, WEST
    }

    private enum Direction {
        IN, OUT, INOUT
    }

    public void add(T vehicle) {
        System.out.println("\nA car has entered Parking");
        if (vehicleList.size() < capacity) {
            this.park(vehicle);
            System.out.println("Parking count remain: " + (capacity - vehicleList.size()));
        } else {
            System.out.println("Parking count max is : " + capacity);
            this.waiting.add(vehicle);
        }
        System.out.println("Waiting amount : " + waiting.size());
        this.vehicleList.add(vehicle);
    }

    public void park(T vehicle) {
        this.vehicleList.add(vehicle);
    }

    public void exit(T vehicle) {
        if (vehicle == null)
            return;
        vehicleList.remove(vehicle);
        System.out.println("Vehicle is leaving");
        if (!waiting.isEmpty()) {
            T waitingVehicle = waiting.poll();
            park(waitingVehicle);
        }
        System.out.println("Waiting amount : " + waiting.size());
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
