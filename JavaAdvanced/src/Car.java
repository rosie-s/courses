import java.util.Scanner;

public class Vehicle {
    private static int count = 0;

    public final int id;
    public String brand;

    public Vehicle() {
        this.id = count++;
    }

    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Car brand?");
        this.brand = scanner.nextLine();
    }

   /* public final void honk(){
        System.out.println("Honk");
    }*/
}
