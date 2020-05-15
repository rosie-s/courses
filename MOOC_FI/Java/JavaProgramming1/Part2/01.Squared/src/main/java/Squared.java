
import java.util.Scanner;

public class Squared {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variable
        int first = Integer.valueOf(scanner.nextLine());

        // Square inputs
        int squared = first * first;

        // Print result
        System.out.println(squared);
    }
}
