
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int positiveCount = 0;

        while (true) {
            int number = Integer.valueOf(scanner.nextLine());

            if (number == 0) {
                break;
            }

            if (number < 0) {
                continue;
            }

            positiveCount = positiveCount + 1;
            sum = sum + number;
        }
        if (sum <= 0) {
            System.out.println("Cannot calcualte the average");
        } else {
            System.out.println((double) sum / positiveCount);

        }
    }
}
