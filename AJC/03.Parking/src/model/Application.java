package model;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Parking aParking = new Parking("Name", "Code");
        aParking.add(new RegisteredCar("Toyota"));
        aParking.add(new RegisteredCar("Audi"));
        aParking.add(new UnregisteredCar("Ferrari"));
        aParking.add(new UnregisteredCar("Renault"));
        aParking.add(new RegisteredTruck("Ford"));
        aParking.add(new RegisteredTruck("Fiat"));
        aParking.add(new UnregisteredTruck("Tesla"));
        aParking.add(new UnregisteredTruck("Porsche"));
        System.out.println(aParking.getVehicleList().size() + " vehicles, Unregistered total cost is: " + aParking.calculateTotalPrice() + "EUR");
  }
}
