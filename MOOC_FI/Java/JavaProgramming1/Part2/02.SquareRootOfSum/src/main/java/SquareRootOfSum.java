
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variable
        int first = Integer.valueOf(scanner.nextLine());
        int second = Integer.valueOf(scanner.nextLine());

        // Square root of sums
        int sum = first + second;
        double squareRoot = Math.sqrt(sum);

        
        // Print result
        System.out.println((int)squareRoot);
    }
}
