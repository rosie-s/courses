
import java.util.Scanner;

public class Orwell {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give a numebr:");
        int value = Integer.valueOf(scan.nextLine());

        if (1984 == value) {
            System.out.println("Orwell");
        }
    }
}
