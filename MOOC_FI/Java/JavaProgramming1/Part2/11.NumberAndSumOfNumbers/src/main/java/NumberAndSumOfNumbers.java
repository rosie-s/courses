
import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Initialize variable to keep count
        int totalNumber = 0;
        int totalInput = 0;

        while (true) {
            // Retrieve input
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());

            // Exit loop if input is 0
            if (number == 0) {
                break;
            }
            
            // Total numbers inputted and total INPUT
            totalNumber = totalNumber + 1;
            totalInput = totalInput + number;
        }
        // Print total negative input
        System.out.println("Number of numbers: " + totalNumber);
        System.out.println("Sum of the numbers: " + totalInput);
    }
}
