package pattern.decorator;

import model.parking.UnregisteredCar;

import java.sql.SQLOutput;

public class UnregisteredCustomCar extends UnregisteredCarDecorator {
    UnregisteredCar car;
    private int extraFees;
    private String comment;

    public UnregisteredCustomCar(UnregisteredCar car, int extraFees, String comment) {
        super(car);
        this.extraFees = extraFees;
        this.comment = comment;

    }

    @Override
    public int getTollGatePrice() {
        return extraFees;
    }

    @Override
    public String toString() {
        return "{ Extra fees: " + extraFees + ", Comment: " + comment + "}";
    }
}
