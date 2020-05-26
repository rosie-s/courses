package model;

public class UnregisteredTruck extends Truck implements TollGatePayable{
    public UnregisteredTruck(String brand) {
        super(brand);
    }

    @Override
    public double payTollGate() {
        return 5.00;
    }
}
