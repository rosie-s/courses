package model;

public class UnregisteredCar extends Car implements TollGatePayable{
    public UnregisteredCar(String brand) {
        super(brand);
    }

    @Override
    public double payTollGate() {
        return 3.00;
    }
}
