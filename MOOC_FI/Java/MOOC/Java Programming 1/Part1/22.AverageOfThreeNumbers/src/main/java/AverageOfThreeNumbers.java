
import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Retrieve numbers
        System.out.println("Give the first number:");
        int first = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int second = Integer.valueOf(scanner.nextLine());        
        System.out.println("Give the third number:");
        int third = Integer.valueOf(scanner.nextLine());

        // Calculate average
        double average = (first + second + third) / (double) 3;
        System.out.println("The average is " + average);
        
        
    }
}
