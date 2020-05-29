package printer.model;

public class Printer {
    public int id;
    public String name;

    public  Printer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void print (String message){
        System.out.println(message);
    }
}
