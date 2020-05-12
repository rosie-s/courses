
import java.util.Scanner;

public class CheckingTheAge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Retrieve age
        System.out.println("How old are you?");
        int age = Integer.valueOf(scan.nextLine());

        // Check if age is correct
        if (age >= 0 && age <= 120) {
            System.out.println("OK");
        } else {
            System.out.println("Impossible!");
        }
    }
}
