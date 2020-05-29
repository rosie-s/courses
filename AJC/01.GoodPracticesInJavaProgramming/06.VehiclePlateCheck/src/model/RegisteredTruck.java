package model;

public final class RegisteredTruck extends Truck {

    public RegisteredTruck(String brand, String plate) {
        super(brand, plate);
        System.out.println("Registered Truck " + this.brand + " created with plate: " + plate);
    }
}
