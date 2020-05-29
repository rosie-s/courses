package model;

public class Application {

    public static void main(String[] args) {

        Parking allParking = new Parking("Public", "JJA");
        allParking.add(new UnregisteredCar("Renault", "0001"));
        allParking.add(new RegisteredCar("Bentley", "0002"));
        allParking.add(new RegisteredCar("Lamborghini", "0003"));
        allParking.add(new RegisteredTruck("Jeep", "0004"));
        allParking.add(new UnregisteredCar("Renault", "0005"));
        allParking.add(new RegisteredCar("Bentley", "0006"));
        allParking.add(new RegisteredCar("Lamborghini", "0007"));
        allParking.add(new RegisteredTruck("Jeep", "0008"));
        allParking.add(new UnregisteredCar("Renault", "0009"));
        allParking.add(new RegisteredCar("Bentley", "0010"));
        allParking.add(new RegisteredCar("Lamborghini", "0011"));
        allParking.add(new RegisteredTruck("Jeep", "0012"));
        allParking.add(new UnregisteredCar("Renault", "0013"));
        allParking.add(new RegisteredCar("Bentley", "0014"));
        allParking.add(new RegisteredCar("Lamborghini", "0015"));
        allParking.add(new RegisteredTruck("Jeep", "0016"));
        allParking.add(new RegisteredTruck("Jeep", "0017"));
        allParking.add(new RegisteredTruck("Jeep", "0018"));
        allParking.add(new RegisteredTruck("Jeep", "0019"));

        System.out.println("\n********** Use exit");

        allParking.exit(new RegisteredTruck("Jeep", "0019"));

    }
}
