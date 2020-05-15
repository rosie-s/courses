
import java.util.Scanner;

public class NumberOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalInput = 0;

        while (true) {
            // Retrieve input
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());

            // Exit loop if input is 0
            if (number == 0) {
                break;
            }

            // Increase input count
            totalInput = totalInput + 1;
        }
        // Print total input
        System.out.println("Number of numbers: " + totalInput);
    }
}
