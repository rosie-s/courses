package parking.model;

import java.util.Objects;

public abstract class Vehicle implements Cloneable {

    private static int count = 0;

    public long ID;
    public String brand;
    public int gaz = 100;
    public String plate;


    public Vehicle(String brand, String plate) {
        this.brand = brand;
        this.ID = count++;
        this.plate = plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(plate, vehicle.plate);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(plate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + ID +
                ", brand='" + brand + '\'' +
                ", gaz=" + gaz +
                ", plate='" + plate + '\'' +
                '}';
    }
}
