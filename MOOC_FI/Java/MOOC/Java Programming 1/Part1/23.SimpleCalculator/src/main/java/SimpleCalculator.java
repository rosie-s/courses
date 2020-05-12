
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Retrieve numbers
        System.out.println("Give the first number:");
        int first = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int second = Integer.valueOf(scanner.nextLine());

        // Calculate sum
        int sum = first + second;
        // Calculate difference
        int difference = first - second;
        // Calculate product
        int product = first * second;
        // Calculate quotient
        double quotient = first / (double) second;

        //Prinr results
        System.out.println(first + " + " + second + " = " + sum);
        System.out.println(first + " - " + second + " = " + difference);
        System.out.println(first + " * " + second + " = " + product);
        System.out.println(first + " / " + second + " = " + quotient);

    }
}
