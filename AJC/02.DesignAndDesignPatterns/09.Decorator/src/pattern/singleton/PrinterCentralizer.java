package pattern.singleton;


import java.util.ArrayList;
import java.util.List;

public class PrinterCentralizer {

    private static PrinterCentralizer instance = null;
    private List<Printer> printers = new ArrayList<>();

    private int printerIndex = 0;

    private PrinterCentralizer() {
        printers.add(new Printer(1, "Epson 400"));
    }

    public static PrinterCentralizer getInstance() {
        if (instance == null) {
            instance = new PrinterCentralizer();
        }
        return instance;
    }

    public void addPrinter(Printer printer){
        printers.add(printer);
    }

    public void print (String message) {
        Printer printer = printers.get(printerIndex);
        printer.print(new StringBuilder(message).append(printer.name).toString());
        if (printerIndex++ >= printers.size()){
            printerIndex = 0;
        }
    }
}
