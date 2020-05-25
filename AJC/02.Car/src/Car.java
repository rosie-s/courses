import java.util.Scanner;

public class Car {
    private static int count = 0;

    public final int id;
    public String brand;

    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Car brand?");
        this.brand = scanner.nextLine();
    }

    public Car() {
        this.id = count++;
    }
}
