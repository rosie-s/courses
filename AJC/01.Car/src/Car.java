import java.util.Scanner;

public class Car {
    private static int count = 0;

    public final int id;
    public String brand;

    public Car() {
        this.id = count++;
    }
}
