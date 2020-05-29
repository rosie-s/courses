package model.parking;

public class UnregisteredTruck extends Truck implements TollGatePayable {
    public UnregisteredTruck(String brand, String plate) {
        super(brand, plate);
    }

    @Override
    public double payTollGate() {
        return 5.00;
    }
}
