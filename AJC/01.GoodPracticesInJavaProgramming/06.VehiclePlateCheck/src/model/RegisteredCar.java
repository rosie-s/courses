package model;

public final class RegisteredCar extends Car {
    public RegisteredCar(String brand, String plate) {
        super(brand, plate);
        System.out.println("Registered Car " + this.brand + " created with plate: " + plate);
    }

}
