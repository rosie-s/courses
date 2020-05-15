
import java.util.Scanner;

public class NumberOfNegativeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variable to keep count
        int negativeCount = 0;

        while (true) {
            // Retrieve input
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());

            // Exit loop if input is 0
            if (number == 0) {
                break;
            }

            // Increase count if input is negative
            if (number < 0) {
                negativeCount = negativeCount + 1;
            }
        }
        // Print total negative input
        System.out.println("Number of negative numbers: " + negativeCount);
    }
}
