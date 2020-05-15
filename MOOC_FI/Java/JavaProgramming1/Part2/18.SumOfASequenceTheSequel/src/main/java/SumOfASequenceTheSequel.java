
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First number
        System.out.print("First number? ");
        int start = Integer.valueOf(scanner.nextLine());

        // First number
        System.out.print("Last number? ");
        int end = Integer.valueOf(scanner.nextLine());

        // Sum 
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum = sum + i;
        }
        System.out.println("The sum is: " + sum);
    }
}
