package model.parking;

public class UnregisteredCar extends Car implements TollGatePayable {
    public UnregisteredCar(String brand, String plate) {
        super(brand, plate);
    }

    @Override
    public double payTollGate() {
        return 3.00;
    }
}
