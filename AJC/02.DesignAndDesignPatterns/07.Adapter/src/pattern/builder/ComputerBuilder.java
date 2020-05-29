package pattern.builder;

import printer.model.Computer;

public class ComputerBuilder {
    Computer computer;

    public ComputerBuilder(String serial, int memory, float proc){

        this.computer = new Computer(serial, memory, proc);
    }

    public ComputerBuilder withGraphicCard(String graphicCard)
    {
        this.computer.setGraphicCardName(graphicCard);
        return this;
    }

    public  ComputerBuilder isLaptop(){
        this.computer.setLaptop(true);
        return this;
    }

    public  ComputerBuilder setOnline(){
        this.computer.setOnline(true);
        return this;
    }

    public Computer build() {
        return this.computer;
    }
}
