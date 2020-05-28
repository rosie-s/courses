package pattern.decorator;

import model.parking.TollGatePayable;
import model.parking.UnregisteredCar;

public abstract class UnregisteredCarDecorator implements TollGatePayable {
    UnregisteredCar car;

    public UnregisteredCarDecorator(UnregisteredCar car) {
        this.car = car;
    }

    @Override
    public double payTollGate() {
        return 0;
    }

    @Override
    public int getTollGatePrice() {
        return 0;
    }
}
