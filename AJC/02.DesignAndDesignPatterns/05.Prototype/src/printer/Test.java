package printer;

import printer.model.Computer;
import printer.model.Printer;
import printer.model.PrinterCentralizer;

public class Test {

    public static void main(String[] args) {

        PrinterCentralizer printerCentralizer = PrinterCentralizer.getInstance();
        printerCentralizer.getInstance().addPrinter(new Printer(2, "Canon"));
        printerCentralizer.getInstance().addPrinter(new Printer(3, "Dell"));
        printerCentralizer.getInstance().addPrinter(new Printer(4, "MSI"));
        printerCentralizer.getInstance().addPrinter(new Printer(5, "HP"));

        Computer c1 = new Computer(1, "PC Canon");
        Computer c2 = new Computer(2, "PC Dell");
        Computer c3 = new Computer(3, "PC MSI");
        Computer c4 = new Computer(4, "PC HP");

        c1.print("Hi");
        c2.print("Hello");
        c3.print("Bonjour");
        c4.print("Salut");
        c2.print("Bye");

    }
}
