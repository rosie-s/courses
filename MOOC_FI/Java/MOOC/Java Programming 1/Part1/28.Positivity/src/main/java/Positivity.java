
import java.util.Scanner;

public class Positivity {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give number:");
        int value = Integer.valueOf(scan.nextLine());
        
        if (value > 0){
            System.out.println("The number is positive.");
        } else {
            System.out.println("The number is not positive.");
        }
        
    }
}
