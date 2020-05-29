package pattern.decorator;

import model.parking.UnregisteredCar;

public class UnregisteredTrailedCar extends UnregisteredCarDecorator {
    public UnregisteredCar car;
    public TrailSize trailSize;

    public UnregisteredTrailedCar(UnregisteredCar car, TrailSize trailSize) {
        super(car);
        this.trailSize = trailSize;
    }

    @Override
    public int getTollGatePrice() {
        int price = 0;
        if (trailSize.equals(TrailSize.SMALL)) {
            price = 1;
        } else if (trailSize.equals(TrailSize.MEDIUM)) {
            price = 3;
        } else if (trailSize.equals(TrailSize.BIG)) {
            price = 5;
        } else {
            return 0;
        }
        return price;
    }
}
