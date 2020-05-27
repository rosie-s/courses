package printer.model;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Computer {
    public int id;
    public String name;

    public Computer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void print(String message) {
        // Call of the singleton
        PrinterCentralizer.getInstance().print(new StringBuilder(name).append(" prints ").append(message).append(" on ").toString());
    }
}
