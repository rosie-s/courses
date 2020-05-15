
import java.util.Scanner;

public class AbsoluteValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.valueOf(scanner.nextLine());

        if (input < 0) {
            System.out.println(input * -1);
        } else {
            System.out.println(input);
        }
    }
}