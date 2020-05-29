package model;

public abstract class Vehicle {

    private static int count = 0;

    public long ID;
    public String brand;
    public  int gaz = 100;


    public Vehicle(String brand) {
        this.brand = brand;
        this.ID = count++;
    }

}
