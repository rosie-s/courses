package printer;

import printer.builder.ComputerBuilder;
import printer.model.Computer;


public class Test {

    public static void main(String[] args) {

        // Computer model
        ComputerBuilder computerBuilder = new ComputerBuilder("0001", 16, 6);
        Computer computer = computerBuilder
                .setOnline()
                .isLaptop()
                .withGraphicCard("GTX 1060")
                .build();
        System.out.println(computer);
    }
}
